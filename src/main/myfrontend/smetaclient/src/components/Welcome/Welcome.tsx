import React from "react";
import Jumbotron from "react-bootstrap/Jumbotron";
import Container from "react-bootstrap/Container";

export const Welcome: React.FC = () => {
    return (
        <Container>
            <Jumbotron className="text-center m-3">
                <h1>РемСмет</h1>
                <blockquote className="blockquote">
                    <p>
                        Помощник в мире строительства и ремонта
                    </p>
                </blockquote>
            </Jumbotron>
        </Container>

    )
}