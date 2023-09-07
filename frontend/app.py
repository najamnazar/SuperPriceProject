
from flask import Flask, render_template, request, redirect, url_for, flash
import requests

app = Flask(__name__)
app.secret_key = 'some_secret_key'  # For flash messages
BASE_URL = "http://localhost:8000/api"

@app.route('/')
def index():
    books = requests.get(f"{BASE_URL}/books").json()
    print(books)
    return render_template('index.html', books=books)

@app.route('/update-book/<int:book_id>', methods=['GET', 'POST'])
def update_book(book_id):
    if request.method == 'POST':
        book_name = request.form['book_name']
        book_price = request.form['book_price']

        payload = {
            'name': book_name,
            'price': float(book_price)
        }

        response = requests.put(f"{BASE_URL}/books/{book_id}", json=payload)
        
        if response.status_code == 200:
            flash('Product updated successfully!', 'success')
        else:
            flash('Failed to update book.', 'danger')

        return redirect(url_for('index'))

    # GET request handling, possibly fetching the current book data and showing in a form.
    book = requests.get(f"{BASE_URL}/books/{book_id}").json()
    return render_template('update_book.html', book=book)

@app.route('/delete-book/<int:book_id>', methods=['POST'])
def delete_book(book_id):
    response = requests.delete(f"{BASE_URL}/books/{book_id}")

    if response.status_code == 200:
        flash('Product deleted successfully!', 'success')
    else:
        flash('Failed to delete book.', 'danger')

    return redirect(url_for('index'))



@app.route('/add-book', methods=['POST'])
def add_book():
    book_name = request.form['book_name']
    book_price = request.form['book_price']

    payload = {
        'name': book_name,
        'price': float(book_price)
    }

    response = requests.post(f"{BASE_URL}/books", json=payload)
    
    if response.status_code == 201:
        flash('Product added successfully!', 'success')
    else:
        flash('Failed to add book.', 'danger')

    return redirect(url_for('index'))

if __name__ == '__main__':
    app.run(debug=True)
