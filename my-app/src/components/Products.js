import React from 'react'
import Navbar from './Navbar.js'
import CardContent from './Card.js'
import { Container, Row, Col } from 'react-bootstrap'
import { ProductsData } from './ProductsData.js';

function Products() {
    return (
        <div>
            <Navbar />
            <Container>
                <Row >
                    {ProductsData.map(props => (
                        <Col lg={3}>
                            <CardContent key={props.id} props={props} />
                        </Col>
                    ))}
                </Row>
            </Container>

        </div>
    )
}

export default Products
