import React, { useState, useEffect } from 'react';
import './App.css';
import { Button, Card, Container, Row, Col } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
//import { setEnvironmentData } from 'worker_threads';
import { Link } from 'react-router-dom'

function Item({ match }) {
    useEffect(() => {
        console.log(match);
        fetchItems();

    }, []);

    const [items, setItems] = useState([

    ]);

    const fetchItems = async () => {
        const data = await
            fetch(`https://fakestoreapi.com/products/category/${match.params.id}`).then(res => res.json());


        // .then(json=>console.log(json)); ////fetch('https://fakestoreapi.com/products/');

        const items = data;//await data.json();
        console.log(items);
        setItems(items);
    }
    return (
        <Container className="up-marg">
  <Row>
            {items.map((item) => (
                <Col  key={`div` + item.id}>
                    <Card className="my-card" style={{ width: '18rem' }}>
                        <Card.Img id="img-card" variant="top" key={`img` + item.id} src={item.image} />
                        <Card.Body>
                            <Card.Title key={`title` + item.id}>{item.title}</Card.Title>
                            <Card.Text className="long-text">
                            {item.description}
                            </Card.Text>
                            <Button variant="primary">Go somewhere</Button>
                        </Card.Body>
                    </Card>
                    {/* <h1 key={`title` + item.id}>{item.title}</h1>
                    <img key={`img` + item.id} src={item.image} alt="" /> */}
                </Col>
            ))}
        </Row>
        </Container>
    );
}

export default Item;
