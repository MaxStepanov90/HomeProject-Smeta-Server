import React from "react";
import {Nav, Navbar} from "react-bootstrap";
import {Link} from "react-router-dom";


export const NavigationBar: React.FC = () => {
    return (

        <Navbar expand="sm" bg="light">
            <Link to={"/"} className="navbar-brand">РемСмет</Link>
            <Navbar.Toggle aria-controls="basic-navbar-nav"/>
            <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="mr-auto">
                    <Link to={"/addProject"} className="nav-link">Создать проект</Link>
                    <Link to={"/projects"} className="nav-link">Список проектов</Link>
                    <Link to={"/markUps"} className="nav-link">Наценки</Link>
                    <Link to={"/info"} className="nav-link">Контакты</Link>
                </Nav>
            </Navbar.Collapse>
        </Navbar>
    )
}