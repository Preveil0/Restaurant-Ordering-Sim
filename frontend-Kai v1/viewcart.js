let cart = JSON.parse(sessionStorage.getItem('cart')) || [];

function renderCart() {
    const tbody = document.querySelector('#cartTable tbody');
    tbody.innerHTML = '';
    let total = 0;

    cart.forEach((item, index) => {
        const tr = document.createElement('tr');

        tr.innerHTML = `
            <td>${item.name}</td>
            <td>₱ ${item.price.toFixed(2)}</td>
            <td>
                <button class="qty-btn" onclick="changeQty(${index}, -1)">−</button>
                ${item.quantity}
                <button class="qty-btn" onclick="changeQty(${index}, 1)">+</button>
            </td>
            <td>
                <button class="delete-btn" onclick="deleteItem(${index})">🗑</button>
            </td>Item Name
        `;

        tbody.appendChild(tr);

        total += item.price * item.quantity;
    });

    document.getElementById('totalPrice').innerText = `Order Total: ₱ ${total.toFixed(2)}`;
}

function changeQty(index, delta) {
    cart[index].quantity += delta;
    if (cart[index].quantity <= 0) {
        cart.splice(index, 1);
    }
    sessionStorage.setItem('cart', JSON.stringify(cart));
    renderCart();
}

function deleteItem(index) {
    cart.splice(index, 1);
    sessionStorage.setItem('cart', JSON.stringify(cart));
    renderCart();
}

renderCart();
