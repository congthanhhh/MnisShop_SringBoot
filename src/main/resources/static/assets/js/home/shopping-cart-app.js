const app = angular.module("shopping-cart-app", []);
app.controller("shopping-cart-ctrl", function ($scope, $http) {


  //Quan ly gio hang
  $scope.cart = {
    items: [],
    selectedColorId: null,
    selectedSizeId: null,
    selectedColorName: null,
    selectedSizeName: null,

    selectColor(id) {
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
      let item = this.items.find((item) => item.id === id);
      if (item) {
        item.qty++;
        this.saveToLocalStorage();
      } else {
        $http.get(`/rest/products/${id}`).then((resp) => {
          resp.data.qty = 1;

          resp.data.colorId = this.selectedColorId;
          resp.data.sizeId = this.selectedSizeId;
          resp.data.colorName = this.selectedColorName;
          resp.data.sizeName = this.selectedSizeName;

          this.items.push(resp.data);
          this.saveToLocalStorage();
        });
      }
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
          .map((item) => item.qty * item.price)
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
    address: "",
    account: { username: $("#username").text() },
    get orderDetails() {
      return $scope.cart.items.map((item) => {
        return {
          product: { id: item.id },
          price: item.price,
          quantity: item.qty,
        };
      });
    },
    purchase() {
      var order = angular.copy(this);
      //Thuc hien dat hang
      $http
        .post("/rest/orders", order)
        .then((resp) => {
          alert("Checkout successfully!");
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
