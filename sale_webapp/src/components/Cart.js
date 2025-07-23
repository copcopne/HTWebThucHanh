import { useState } from "react";
import { Alert, Button, Table } from "react-bootstrap";
import cookie from 'react-cookies'

const Cart = () => {
    const [cart, setCart] = useState(cookie.load('cart') || null);

    return (
        <>
            <h1 className="text-center text-success mt-2">GIỎ HÀNG</h1>

            {cart === null ? <Alert variant="warning">KHÔNG có sản phẩm trong giỏ!</Alert>:<>
                <Table striped bordered hover>
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Tên sản phẩm</th>
                            <th>Đơn giá</th>
                            <th>Số lượng</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        {Object.values(cart).map(c => <tr>
                            <td>{c.id}</td>
                            <td>{c.name}</td>
                            <td>{c.price}</td>
                            <td>{c.quantity}</td>
                            <td>
                                <Button variant="danger">&times;</Button>
                            </td>
                        </tr>)}
                        
                    </tbody>
                </Table>

                <div className="mt-1 mb-1">
                    <Button variant="success">Thanh toán</Button>
                </div>
                
            </>}
            
        </>
    );
}

export default Cart;