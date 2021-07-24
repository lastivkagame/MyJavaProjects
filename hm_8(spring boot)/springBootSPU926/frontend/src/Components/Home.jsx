import { React, Component } from 'react'
import { Button, Card, Container, Row, Col } from 'react-bootstrap';
import {useState, useEffect} from 'react';

function Home () {
    // componentDidMount() {
    //     fetch("https://fakestoreapi.com/products/").then(x => console.log(x.json()));
    // }
   
    
    // componentDidMount() {
    // const data = fetch('http://localhost:8080/api/animals')
    //     .then(response => response.json())
    //     .then(data => console.log(data));
    //     //.then(data => this.setState({clients: data}));

    //     this.props.items = data;
    //     }
    useEffect(()=>{
        fetchItems();
       
    }, []);

    const [items, setItems] = useState([]);

    
    
    const fetchItems =  async () => {
        const data = await 
        fetch('http://localhost:8080/api/animals'); ///categories .. products/ 
        //.then(res=>res.json())
        
           // .then(json=>console.log(json)); ////fetch('https://fakestoreapi.com/products/');

        const items = await data.json();
        let noImage = "https://res.cloudinary.com/dk-find-out/image/upload/q_80,w_1920,f_auto/Animal_kingdom_nzwbda.jpg";

        items.forEach(element => {
            if(element.image == "" || element.image == null){
                element.image = noImage;
            }
        });
        console.log(items);
        setItems(items);
    }

        return (
            // <GetAnimals />
            <Container className="up-marg">
            <Row>
            {items.map((item) => (
                <Col  key={`div` + item.id}>
                    <Card className="my-card" style={{ width: '18rem' }}>
                        <Card.Img id="img-card" variant="top" key={`img` + item.id} src={item.image} />
                        <Card.Body>
                            <Card.Title key={`title` + item.id}>{item.name}</Card.Title>
                           
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

function GetAnimals(){

    useEffect(()=>{
        fetchItems();
       
    }, []);

    const [items, setItems] = useState([]);

    const fetchItems =  async () => {
        const data  = await fetch('http://localhost:8080/api/animals');
        //.then(response => response.json())
        //.then(data => console.log(data));
        //.then(data => this.setState({clients: data}));
        //};
       // console.log(items);
       const items = await data.json();
        console.log(items);
        setItems(items);
    }

    return(
            <Container className="up-marg">
            <Row>
            {items.map((item) => (
                <Col  key={`div` + item.id}>
                    <Card className="my-card" style={{ width: '18rem' }}>
                        <Card.Img id="img-card" variant="top" key={`img` + item.id} src={item.image} />
                        <Card.Body>
                            <Card.Title key={`title` + item.id}>{item.title}</Card.Title>
                           
                            <Button variant="primary">Go somewhere</Button>
                        </Card.Body>
                    </Card>
                </Col>
            ))}
            </Row>
        </Container>
    );

}

export default Home