import { useContext, useEffect, useState } from "react";
import { Badge, Container, Nav, Navbar, NavDropdown } from "react-bootstrap";
import Apis, { endpoints } from "../../configs/Apis";
import { Link } from "react-router-dom";
import { MyCartContext } from "../../configs/Contexts";

const Header = () => {
    const [categories, setCategories] = useState([]);
    const [cartCounter, ] = useContext(MyCartContext);

    const loadCates = async () => {
        let res = await Apis.get(endpoints['categories']);
        setCategories(res.data);
    }

    useEffect(() => {
        loadCates();
    }, []);

    return (
        <>
            <Navbar expand="lg" className="bg-body-tertiary">
            <Container>
            <Link className="navbar-brand" to="/">eCommerce Website</Link>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="me-auto">
                    <Link className="nav-link" to="/">Trang chủ</Link>
                    <NavDropdown title="Danh mục" id="basic-nav-dropdown">
                        {categories.map(c => <Link to={`/?cateId=${c.id}`} key={c.id}  className='dropdown-item'>{c.name}</Link>)}
                    </NavDropdown>
                <Link className="nav-link" to="/cart">Giỏ hàng <Badge>{cartCounter}</Badge></Link>
                <Link to="/register" className="nav-link text-info">Đăng ký</Link>
                <Link to="/login" className="nav-link text-info">Đăng nhập</Link>
                </Nav>
                </Navbar.Collapse>
            </Container>
            </Navbar>
        </>
    );
}

export default Header;