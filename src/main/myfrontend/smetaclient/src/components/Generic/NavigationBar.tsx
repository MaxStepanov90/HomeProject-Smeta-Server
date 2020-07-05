import React from "react";
import {Nav, Navbar} from "react-bootstrap";


export const NavigationBar: React.FC = () => {
    return (

        <Navbar expand="sm" bg="light">
            <Navbar.Brand href={"/"}>РемСмет</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav"/>
            <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="mr-auto">
                    <Nav.Link href={"/addProject"}>Создать проект</Nav.Link>
                    <Nav.Link href={"/projects"}>Список проектов</Nav.Link>
                    <Nav.Link href={"/markUps"}>Наценки</Nav.Link>
                    <Nav.Link href={"/info"} disabled={true}>Контакты</Nav.Link>
                </Nav>
            </Navbar.Collapse>
        </Navbar>
    )
}
