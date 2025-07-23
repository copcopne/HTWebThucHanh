import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./components/layout/Header";
import Footer from "./components/layout/Footer";
import Home from "./components/Home";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Container } from "react-bootstrap";
import { MyCartContext } from "./configs/Contexts";
import { useReducer } from "react";
import MyCartReducer from "./reducers/MyCartReducer";
import Cart from "./components/Cart";
import Register from "./components/Register";
import Login from "./components/Login";

const App = () => {
  const [cartCounter, cartDispatch] = useReducer(MyCartReducer, 0);
  return (
    <MyCartContext.Provider value={[cartCounter, cartDispatch]}>
      <BrowserRouter>
        <Header />

        <Container>
          <Routes>
          <Route path="/" element={<Home />} />
            <Route path="/cart" element={<Cart />} />
            <Route path="/register" element={<Register />} />
            <Route path="/login" element={<Login />} />
          </Routes>
        </Container>

        <Footer />
      </BrowserRouter>
    </MyCartContext.Provider>
  );
}

export default App;