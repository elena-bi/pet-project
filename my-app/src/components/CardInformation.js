import axios from "axios";
import React, { useState, useEffect } from "react";
import { Container, Row, Col } from 'react-bootstrap';
import Card from './Card.js';



const CardInformation = () => {
    const [cardInformation, setCardInformation] = useState([]);

    const fetchCardInformation = () => {
        axios.get("http://localhost:8080/api/v1/products").then(resp => {
            console.log(resp);
            setCardInformation(resp.data);
        });

    }

    useEffect(() => {
        fetchCardInformation();
    }, [])

    return cardInformation.map((cardInformation, index) => {

        return (
            <div key={index}>
                <Container>
                    <Row >
                        <Col lg={3}>
                            <Card key={index} props={cardInformation} />
                        </Col>

                    </Row>
                </Container>
            </div>)
    })
}

export default CardInformation
