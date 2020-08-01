import React from "react";
import {Nav, Navbar} from "react-bootstrap";
import {Link} from "react-router-dom";
import NavDropdown from "react-bootstrap/NavDropdown";


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
                <NavDropdown className="nav-link" title="Выберите язык" id="basic-nav-dropdown">
                    <NavDropdown.Item data-google-lang="ru" className="language__img">русский</NavDropdown.Item>
                    <NavDropdown.Item data-google-lang="en" className="language__img">английский</NavDropdown.Item>
                    <NavDropdown.Item data-google-lang="de" className="language__img">немецкий</NavDropdown.Item>
                    <NavDropdown.Item data-google-lang="fr" className="language__img">французский</NavDropdown.Item>
                    <NavDropdown.Item data-google-lang="pt" className="language__img">португальский</NavDropdown.Item>
                    <NavDropdown.Item data-google-lang="es" className="language__img">испанский</NavDropdown.Item>
                    <NavDropdown.Item data-google-lang="it" className="language__img">итальянский</NavDropdown.Item>
                    <NavDropdown.Item data-google-lang="ar" className="language__img">арабский</NavDropdown.Item>
                </NavDropdown>
            </Navbar.Collapse>
        </Navbar>
    )
}