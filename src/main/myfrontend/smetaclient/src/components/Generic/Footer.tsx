import React from "react";
import Navbar from "react-bootstrap/Navbar";
import Container from "react-bootstrap/Container";
import Col from "react-bootstrap/Col";

export const Footer: React.FC = () => {

    let fullYear = new Date().getFullYear();

    return (
        <Navbar expand="sm" fixed="bottom" bg="light">
            <Container>
                <Col lg={12} className="text-center text-muted">
                    <div>{fullYear}-{fullYear + 1},&nbsp;Все права защищены</div>
                </Col>
            </Container>
        </Navbar>
    )
}
