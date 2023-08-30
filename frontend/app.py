
from flask import Flask, render_template, request, redirect, url_for, flash
import requests

app = Flask(__name__)
app.secret_key = 'some_secret_key'  # For flash messages
BASE_URL = "http://localhost:8000/api"

@app.route('/')
def index():
    products = requests.get(f"{BASE_URL}/products").json()
    return render_template('index.html', products=products)

@app.route('/update-product/<int:product_id>', methods=['GET', 'POST'])
def update_product(product_id):
    if request.method == 'POST':
        product_name = request.form['product_name']
        product_price = request.form['product_price']

        payload = {
            'name': product_name,
            'price': float(product_price)
        }

        response = requests.put(f"{BASE_URL}/products/{product_id}", json=payload)
        
        if response.status_code == 200:
            flash('Product updated successfully!', 'success')
        else:
            flash('Failed to update product.', 'danger')

        return redirect(url_for('index'))

    # GET request handling, possibly fetching the current product data and showing in a form.
    product = requests.get(f"{BASE_URL}/products/{product_id}").json()
    return render_template('update_product.html', product=product)

@app.route('/delete-product/<int:product_id>', methods=['POST'])
def delete_product(product_id):
    response = requests.delete(f"{BASE_URL}/products/{product_id}")

    if response.status_code == 200:
        flash('Product deleted successfully!', 'success')
    else:
        flash('Failed to delete product.', 'danger')

    return redirect(url_for('index'))



@app.route('/add-product', methods=['POST'])
def add_product():
    product_name = request.form['product_name']
    product_price = request.form['product_price']

    payload = {
        'name': product_name,
        'price': float(product_price)
    }

    response = requests.post(f"{BASE_URL}/products", json=payload)
    
    if response.status_code == 201:
        flash('Product added successfully!', 'success')
    else:
        flash('Failed to add product.', 'danger')

    return redirect(url_for('index'))

if __name__ == '__main__':
    app.run(debug=True)
