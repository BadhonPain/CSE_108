#include <iostream>
#include <string>

using namespace std;

class Product {
private:
    string productName;
    string productID;
    double price;
    int stockChanges[100];
    int numStockChanges;

public:
    Product() {
        productName = "";
        productID = "";
        price = 0.0;
        numStockChanges = 0;
        for (int i = 0; i < 100; i++) {
            stockChanges[i] = 0;
        }
    }

    Product(string productName, string productID, double price) {
        this->productName = productName;
        this->productID = productID;
        this->price = price;
        this->numStockChanges = 0;
        for (int i = 0; i < 100; i++) {
            stockChanges[i] = 0;
        }
    }

    string getProductID() const { 
        return productID; 
    }
    
    int getNumStockChanges() const { 
        return numStockChanges; 
    }

    void addStock(int amount) {
        if (numStockChanges < 100) {
            stockChanges[numStockChanges++] = amount;
        }
    }

    void reduceStock(int amount) {
        if (numStockChanges < 100) {
            stockChanges[numStockChanges++] = -amount; // Store reduction as negative
        }
    }

    int getCurrentStock() const {
        int currentStock = 0;
        for (int i = 0; i < numStockChanges; i++) {
            currentStock += stockChanges[i];
        }
        return currentStock;
    }

    void display() const {
        cout << "Product: " << productName 
             << " (ID: " << productID 
             << "), Price: Tk." << price 
             << ", Stock: " << getCurrentStock() << "\n";
    }
};

class Inventory {
private:
    Product* products; 
    int numProducts;
    int maxProducts;

public:

        Inventory() {
        maxProducts = 0;
        numProducts = 0;
        products = nullptr;
    }


    Inventory(int maxProducts) {
        this->maxProducts = maxProducts;
        this->numProducts = 0;
        this->products = new Product[maxProducts];
    }


    Inventory(Product* products, int numProducts, int maxProducts) {
        this->maxProducts = maxProducts;
        this->numProducts = numProducts;
        this->products = new Product[maxProducts];
        for (int i = 0; i < numProducts; i++) {
            this->products[i] = products[i];
        }
    }


    Inventory(const Inventory& other) {
        this->maxProducts = other.maxProducts;
        this->numProducts = other.numProducts;
        if (other.products != nullptr) {
            this->products = new Product[this->maxProducts];
            for (int i = 0; i < this->numProducts; i++) {
                this->products[i] = other.products[i];
            }
        } else {
            this->products = nullptr;
        }
    }


    Inventory& operator=(const Inventory& other) {
        if (this != &other) {
            delete[] products;
            this->maxProducts = other.maxProducts;
            this->numProducts = other.numProducts;
            if (other.products != nullptr) {
                this->products = new Product[this->maxProducts];
                for (int i = 0; i < this->numProducts; i++) {
                    this->products[i] = other.products[i];
                }
            } else {
                products = nullptr;
            }
        }
        return *this;
    }


    ~Inventory() {
        delete[] products;
    }


    void addProduct(Product p) {
        if (numProducts < maxProducts) {
            products[numProducts++] = p;
            cout << "Product added with ID:\n" << p.getProductID() << "\n";
        } else {
            cout << "Inventory full. Cannot add any more product.\n";
        }
    }


    void updateProductStock(string productID, int amount) {
        for (int i = 0; i < numProducts; i++) {
            if (products[i].getProductID() == productID) {
                if (amount > 0) {
                    products[i].addStock(amount);
                } else if (amount < 0) {
                    products[i].reduceStock(-amount); // pass absolute value to reduceStock
                }
                return;
            }
        }
    }


    void listAllProducts() const {
        for (int i = 0; i < numProducts; i++) {
            products[i].display();
        }
    }


    Product getMostStockedProduct() const {
        if (numProducts == 0) {
            return Product();
        }

        int maxStockIdx = 0;
        for (int i = 1; i < numProducts; i++) {
            int currentMaxStock = products[maxStockIdx].getCurrentStock();
            int currentItemStock = products[i].getCurrentStock();

            if (currentItemStock > currentMaxStock) {
                maxStockIdx = i;
            } 

            else if (currentItemStock == currentMaxStock) {
                if (products[i].getNumStockChanges() < products[maxStockIdx].getNumStockChanges()) {
                    maxStockIdx = i;
                }
            }
        }
        return products[maxStockIdx];
    }
};

int main() {
    Inventory invl(5);
    
    Product p1("Laptop", "P001", 50000);
    Product p2("Smartphone", "P002", 30000);
    Product p3("Tablet", "P003", 25000);
    Product p4("Smartwatch", "P004", 4000);
    Product p5("Headphones", "P005", 2000);
    Product p6("Charger", "P006", 1000);

    invl.addProduct(p1);
    invl.addProduct(p2);
    invl.addProduct(p3);
    invl.addProduct(p4);
    invl.addProduct(p5);
    invl.addProduct(p6); 

    invl.updateProductStock("P001", 50);
    invl.updateProductStock("P001", -10);
    invl.updateProductStock("P003", 70);
    invl.updateProductStock("P002", 70);
    invl.updateProductStock("P002", -5);
    invl.updateProductStock("P003", -10);

    cout << "\nProducts in Inventory 1:\n";
    invl.listAllProducts();

    cout << "\nMost Stocked Product in Inventory 1:\n";
    invl.getMostStockedProduct().display();

    Inventory inv2 = invl;

    inv2.updateProductStock("P003", 10);
    inv2.updateProductStock("P002", 10);
    inv2.updateProductStock("P002", -5);

    cout << "\nProducts in Inventory 2:\n";
    inv2.listAllProducts();

    cout << "\nMost Stocked Product in Inventory 1:\n";
    invl.getMostStockedProduct().display();

    cout << "\nMost Stocked Product in Inventory 2:\n";
    inv2.getMostStockedProduct().display();

    return 0;
}