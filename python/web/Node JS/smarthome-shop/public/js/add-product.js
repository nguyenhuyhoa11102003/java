$(".custom-file-input").on("change", function() {
    let fileName = $(this).val().split("\\").pop();
    $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
});

function add() {
    let name = $("#name").val();
    let description = $("#description").val();
    let price = $("#price").val();
    let catalog = $("#catalog").val();
    let image = document.getElementById('image');
    let selectedImage = image.files[0];

    if(name === "" || description === "" || price <= 0 || catalog === "")
        return toastr.error("Vui lòng nhập đầy đủ thông tin", "Thông báo");
    
    if(!selectedImage)
        return toastr.error("Vui lòng chọn hình ảnh cho sản phẩm.", "Thông báo");

    if(selectedImage.size > 1048576)
        return toastr.error("Vui lòng upload ảnh nhỏ hơn 1MB.", "Thông báo");

    let reader = new FileReader();
    reader.readAsDataURL(selectedImage);

    // Sau khi reader đã đọc hết data
    reader.onload = () => {
        let base64 = reader.result;

        fetch('/admin/product/add/', {
            method: 'post',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ 
                name: name,
                description: description,
                price: price,
                catalog: catalog,
                base64: base64,
                imageName: $("#image").siblings(".custom-file-label").addClass("selected").html()
            })
        })
        .then(response => response.json())
        .then(json => {
            if(json.code === 1)
                toastr.error(json.message, "Thông báo");
            else {
                toastr.success(json.message, "Thông báo");
    
                setTimeout(() => {
                    document.location.href = "/admin/"
                }, 1500)
            }
        })
    };
}

function reset() {
    location.reload();
}