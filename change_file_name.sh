#!/bin/bash

# Function to rename files and replace content
process_file() {
  local old_filepath=$1
  local new_filepath=$(echo "$old_filepath" | sed 's/Product/Book/gI' | sed 's/product/book/gI')

  # Rename the file
  mv "$old_filepath" "$new_filepath"

  # Replace content in the file
  sed -i 's/Product/Book/gI' "$new_filepath"
  sed -i 's/product/book/gI' "$new_filepath"
}

# Find files containing "Product" or "product" in the filename
find . -type f -iregex '.*product.*' -print0 | while IFS= read -r -d '' file; do
  process_file "$file"
done
