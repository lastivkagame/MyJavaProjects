import { React, Component } from 'react'
<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css"></link>

class AddAnimal extends Component {
    // componentDidMount() {
    //     fetch("https://fakestoreapi.com/products/").then(x => console.log(x.json()));
    // }

    // componentDidMount() {
    // fetch('http://localhost:8080/api/animals')
    //     .then(response => response.json())
    //     .then(data => console.log(data));
    //     //.then(data => this.setState({clients: data}));
    //     }
    state = {
        name: "",
        image: "",
      };

      onNameChange = (e) => {
        this.setState({
          name: e.target.value,
        });
      };

      onImageChange = (e) => {
        this.setState({
          image: e.target.value,
        });
      };

    onSubmitContact = (e) => {
        e.preventDefault();

  fetch("http://localhost:8080/api/animals/add", {
  method: "POST",
  body: JSON.stringify({
    name: this.state.name,
    image: this.state.image
  })
})
  .then(res => {
    if (!response.ok) throw Error(response.statusText);
    return response.json();
  })
  .then(data => console.log(data))
  .catch(error => console.log(error));
        //here add to db

        //this.props.onAdd(this.state);
        //this.setState({
          //name: "",
          //age:"",
        //});
      };

    render(){
        return (
            <>
            <form onSubmit={this.onSubmitContact} className="form-group mt-4">
              <input
                onChange={this.onNameChange}
                name="name"
                placeholder="Enter name"
                className="form-control mb-3"
                value={this.state.name}
              />
              <input
                onChange={this.onImageChange}
                name="image"
                placeholder="Enter image"
                className="form-control"
                value={this.state.image}
              />
    
              <div className="bottom-right">
                <button type="submit" className="btn btn-success">
                  {" "} ADD
                  {/* <i className="fas fa-plus-circle"> </i> */}
                  <i class="fa fa-plus-circle" aria-hidden="true"></i>
                </button>
              </div>
            </form>
            </>
        )
    }
}

export default AddAnimal