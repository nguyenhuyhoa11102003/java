function checkout(totalPrice) {
    totalPrice = parseInt(totalPrice.replaceAll(/[.đ]/g, ""));

    if(totalPrice === 0)
        return toastr.error("Giỏ hàng hiện đang trống", "Thông báo")

    let address = document.getElementById("address");
    if(address.value === "")
        return toastr.error("Vui lòng nhập địa chỉ giao hàng", "Thông báo");

    fetch("/order/checkout", {
        method: "post",
        body: new URLSearchParams({
            totalPrice: totalPrice
        })
    })
    .then(response => response.json())
    .then(json => {
        if(json.code === 0) {
            updateAddress();
            
            toastr.success(json.message, "Thông báo")

            setTimeout(() => {
                document.location.href = "/order/"
            }, 1500)
        }
        else
            toastr.error(json.message, "Thông báo")
    })
}

function updateAddress() {
    fetch("/account/update-address", {
        method: "put",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            address: document.getElementById("address").value
        })
    })
}