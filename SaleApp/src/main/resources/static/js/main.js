function deleteProduct(url) {
    if (confirm("Bạn chắc chắn xóa?") === true) {
        fetch(url, {
            method: "delete"
        }).then(res => {
            if (res.status === 204)
                location.reload();
            else
                alert("Hệ thống đang có lỗi!");
        });

    }
}