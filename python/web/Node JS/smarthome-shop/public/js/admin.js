$(".custom-file-input").on("change", function() {
    let fileName = $(this).val().split("\\").pop();
    $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
});

function showUpdateModal(selectedButton) {
    let selectedProduct = selectedButton.parentNode.parentNode;

    let id = selectedProduct.children[0].innerText;
    let name = selectedProduct.children[1].innerText;
    let description = selectedProduct.children[2].innerText;
    let price = selectedProduct.children[3].innerText.replaceAll(/[.đ]/g, "") - 0;
    let image = selectedProduct.children[4].children[0].dataset.image;
    let catalog = selectedProduct.children[5].innerText;

    $("#id").val(id);
    $("#name").val(name);
    $("#description").val(description);
    $("#price").val(price);
    $("#image").siblings(".custom-file-label").addClass("selected").html(image);
    $("#catalog").find(`option[value="${catalog}"]`).prop("selected", true);

    $("#updateModal").modal("show")
}

function closeUpdateModal() {
    $("#updateModal").modal("hide")
}

async function handleUpdate() {
    let id = $("#id").val();
    let name = $("#name").val();
    let description = $("#description").val();
    let price = $("#price").val();
    let catalog = $("#catalog").val();

    if(name === "" || description === "" || price <= 0 || catalog === "")
        return toastr.error("Vui lòng nhập đầy đủ thông tin", "Thông báo");

    let image = document.getElementById('image');
    let selectedImage = image.files[0];
    
    // Khi admin muốn cập nhật hình ảnh mới
    let base64 = "";

    if (selectedImage) {
        // Kiểm tra kích thước ảnh
        if(selectedImage.size > 1048576)
            return toastr.error("Vui lòng upload ảnh nhỏ hơn 1MB.", "Thông báo");

        let reader = new FileReader();

        base64 = await new Promise((resolve) => {
            reader.readAsDataURL(selectedImage);

            // Sau khi reader đã đọc hết data
            reader.onload = () => {
                resolve(reader.result);
            };
        });
    }

    fetch('/admin/product/update/', {
        method: 'put',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ 
            id: parseInt(id),
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
}

let deletedId;

function showDeleteModal(id) {
    deletedId = id;

    $("#modal-body-delete").html(`Xác nhận xóa sản phẩm có <b>mã là ${id}</b>?`);
    $("#deleteModal").modal("show")
}

function closeDeleteModal() {
    $("#deleteModal").modal("hide")
}

function handleDelete() {
    fetch("/admin/product/delete", {
        method: "delete",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id: deletedId
        })
    })
    .then(response => response.json())
    .then(json => {
        closeDeleteModal();

        if(json.code === 1) 
            toastr.error(json.message, "Thông báo");
        else {
            toastr.success(json.message, "Thông báo");

            setTimeout(() => {
                document.location.href = "/admin/"
            }, 1500)
        }
    })
}