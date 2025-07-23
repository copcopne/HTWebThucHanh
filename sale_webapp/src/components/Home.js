import { useContext, useEffect, useState } from "react";
import { Alert, Button, Card, Col, Form, Row, Spinner } from "react-bootstrap"
import Apis, { endpoints } from "../configs/Apis";
import { useSearchParams } from "react-router-dom";
import cookies from "react-cookies";
import { MyCartContext } from "../configs/Contexts";

const Home = () => {
    const [products, setProducts] = useState([]);
    const [page, setPage] = useState(1);
    const [loading, setLoading] = useState(false);
    const [kw, setKw] = useState(null);
    const [params] = useSearchParams();
    const [, cartDispatch] = useContext(MyCartContext);

    const loadProducts = async () => {
        let url = `${endpoints['products']}?page=${page}`;
        if (kw)
            url = `${url}&kw=${kw}`;
        let cateId = params.get("cateId");
        if (cateId)
            url = `${url}&categoryId=${cateId}`;
        try {
            setLoading(true);
            let res = await Apis.get(url);
            if (res.data.length === 0) {
                setPage(0);
            }
            if (page <= 1){
                setProducts(res.data);
            }
            else
                setProducts([...products, ...res.data]);
        } catch (e) {
            console.error(e);
        } finally {
            setLoading(false);
        }
    };
    useEffect(() => {
        let timer = setTimeout(() => {
            if (page > 0)
                loadProducts();
        }, 500);
        return () => clearTimeout(timer);
    }, [page, kw, params]);

    useEffect(() => {
        setPage(1);
    }, [kw, params]);

    const loadMore = () => {
        setPage(page + 1);
    };
    const order = (product) => {
        let cart = cookies.load("cart") || null;
        if (!cart) {
            cart = {};
        }
        if (product.id in cart) {
            cart[product.id]["quantity"]++;
        } else {
            cart[product.id] = {
                "id": product.id,
                "name": product.name,
                "quantity": 1
            }
        };
        cookies.save("cart", cart);
        cartDispatch({
            "type": "update"
        });
    };
    return (
        <>
            <Form>
                <Form.Group className="mb-3 mt-2">
                    <Form.Control value={kw} onChange={e => setKw(e.target.value)} type="text" placeholder="Nhập từ khóa..." />
                </Form.Group>
            </Form>
            {(!products || products.length === 0) && <Alert className="mt-2" variant="info">Không có sản phẩm nào!!!</Alert>}
            <Row>
                {products.map(p =>
                    <Col key={p.id} md={3} xs={6} className="p-1">
                        <Card>
                            <Card.Img variant="top" src={p.image} />
                            <Card.Body>
                                <Card.Title>{p.name}</Card.Title>
                                <Card.Text>
                                    {p.price} VNĐ
                                </Card.Text>
                                <Button className="m-1" variant="primary">Xem chi tiết</Button>
                                <Button className="m-1" variant="danger" onClick={() => order(p)}>Đặt hàng</Button>
                            </Card.Body>
                        </Card>
                    </Col>
                )}
            </Row>
            {loading && <Spinner className="text-center mt-2" animation="border" variant="primary" />}
            {page > 0 &&
                <div className="m-2 text-center" >
                    <Button onClick={loadMore} variant="secondary">Xem thêm</Button>
                </div>}
        </>
    );
}

export default Home;