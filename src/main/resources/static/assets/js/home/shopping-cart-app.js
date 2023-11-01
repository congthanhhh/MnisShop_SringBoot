const app = angular.module("shopping-cart-app", []);
app.controller("shopping-cart-ctrl", function ($scope, $http) {
  //Quan ly gio hang
  $scope.productAttributeId = null;
  $scope.cart = {
    items: [],
    selectedColorId: null,
    selectedSizeId: null,
    selectedColorName: null,
    selectedSizeName: null,
    selectedQty: 1,

    selectColor(id)  {
      this.selectedColorId = id;
    },
    selectSize(id) {
      this.selectedSizeId = id;
    },
    selectColorName(name) {
      this.selectedColorName = name;
    },
    selectSizeName(name) {
      this.selectedSizeName = name;
    },

    //Them san pham vao gio hang
    add(id) {

      if (this.selectedColorId === null || this.selectedSizeId === null) {
        alert("Vui lòng chọn cả size và color trước khi thêm vào giỏ hàng.");
        return false;
      }

      let item = this.items.find((item) => item.id === id && item.colorId === this.selectedColorId && item.sizeId === this.selectedSizeId);

      if (item) {
        item.qty+= this.selectedQty;
        this.saveToLocalStorage();
      } else {
        $http.get(`/rest/attribute/${id}/${this.selectedColorId}/${this.selectedSizeId}`).then((resp) => {
          resp.data.qty = this.selectedQty;
          resp.data.colorId = this.selectedColorId;
          resp.data.sizeId = this.selectedSizeId;
          this.items.push(resp.data);
          this.saveToLocalStorage();
        });
      }
    },

    showStock(productId) {
      $http.get(`/rest/attribute/${productId}/${this.selectedColorId}/${this.selectedSizeId}`).then((resp) => {
        this.stock = resp.data.stock;
      });
    },

    // //Xoa san pam khoi gio hang
    remove(id) {
      let index = this.items.findIndex((item) => item.id === id);
      this.items.splice(index, 1);
      this.saveToLocalStorage();
    },
    // //Xoa sach cac sản phẩm trong giỏ
    clear() {
      this.items = [];
      this.saveToLocalStorage();
    },

    //Tinh tong so luong cac mat hang trong gio
    get count() {
      return this.items
          .map((item) => item.qty)
          .reduce((total, qty) => (total += qty), 0);
    },
    //Tong thanh tien cac mat hang trong gio
    get amount() {
      return this.items
          .map((item) => item.qty * item.product.price)
          .reduce((total, qty) => (total += qty), 0);
    },

    //Luu gio hang vao local storage
    saveToLocalStorage() {
      let json = JSON.stringify(angular.copy(this.items));
      localStorage.setItem("cart", json);

    },
    //Doc gio hang tu LocalStorage
    loadFromLocalStorage() {
      let json = localStorage.getItem("cart");
      this.items = json ? JSON.parse(json) : [];
    },
  };
  $scope.cart.loadFromLocalStorage();

//Order
  $scope.order = {
    createDate: new Date(),
    phone: "",
    address: "",
    account: { username: $("#orderUsername").text() },
    get orderDetails() {
      return $scope.cart.items.map((item) => {
        return {
          product: { id: item.product.id },
          price: item.product.price,
          quantity: item.qty,
        };
      });
    },

    updateStock(productId, colorId, sizeId, qty) {
      $http.put(`/rest/attribute/stock/${qty}/${productId}/${colorId}/${sizeId}`)
          .then((resp) => {
            console.log("Stock updated successfully");
          })
          .catch((error) => {
            alert("Error when updating stock!");
            console.log(error);
          });
    },


    purchase() {

      if (!this.phone || !this.address) {
        alert("Vui lòng nhập số điện thoại và địa chỉ trước khi thanh toán.");
        return;
      }

      // console.log(this.orderDetails)
      let order = angular.copy(this);
      //Thuc hien dat hang
      $http
        .post("/rest/orders", order)
        .then((resp) => {
          alert("Checkout successfully!");

          // Update stock for each item in the order
          for (let item of $scope.cart.items) {
            let productId = item.product.id;
            let colorId = item.colorId;
            let sizeId = item.sizeId;
            let qty = item.qty;
            $scope.order.updateStock(productId, colorId, sizeId, qty);
          }


          $scope.cart.clear();
          location.href = "/order/detail/" + resp.data.id;
        })
        .catch((error) => {
          alert("Error when you checkout!");
          console.log(error);
        });
    },
  };
});
