#include <iostream>
using namespace std;
class Figure
{
private:
    int row;
    int col;
    string name;
    int **matrix;

    string setName(int r, int c)
    {
        if (c == 2)
        {
            if (r == 2)
            {
                name = "Line2D";
            }
            else if (r == 3)
            {
                name = "Triangle2D";
            }
            else
                name = "Rectangle2D";
        }
        else if (c == 3)
        {
            if (r == 2)
            {
                name = "Line3D";
            }
            else if (r == 3)
            {
                name = "Triangle3D";
            }
            else
                name = "Rectangle3D";
        }
        else
            name = "Invalid !";
        return name;
    }

public:
    Figure()
    {
        row = 0;
        col = 0;
        name = "";
        matrix = nullptr;
    }
    Figure(int r, int c, int arr[])
    {

        row = r;
        col = c;
        setName(r, c);
        int k = 0;
        matrix = new int *[row];
        for (int i = 0; i < row; i++)
        {
            matrix[i] = new int[col];
        }

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                matrix[i][j] = arr[k++];
            }
        }
    }
    Figure(const Figure &newObj)
    {
        this->row = newObj.row;
        this->col = newObj.col;
        this->name = newObj.name;

        matrix = new int *[row];
        for (int i = 0; i < row; i++)
        {
            matrix[i] = new int[col];
        }

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                matrix[i][j] = newObj.matrix[i][j];
            }
        }
    }
    ~Figure()
    {
        if (matrix != nullptr)
        {
            for (int i = 0; i < row; i++)
            {
                delete[] matrix[i];
            }
            delete[] matrix;
        }

        cout << name << " has been destroyed" << endl;
        row = 0;
        col = 0;
        matrix = nullptr;
    }
    int getSum()
    {
        int sum = 0;
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
    int getSum(int m, int n)
    {
        if (m > row || n > col)
        {
            return -1;
        }

        int sum = 0;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
    void showShape()
    {
        cout << name << " :" << endl;
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                cout << matrix[i][j] << " ";
            }
            cout << endl;
        }
    }
};

int main()
{
    int arr[] = {1, 2, 3, 4, 5, 6};
    Figure f1(2, 3, arr);
    f1.showShape();
    cout << "Sum of submatrix : " << f1.getSum(2, 2) << endl;
    cout << "Sum of all elements : " << f1.getSum() << endl
         << endl;

    Figure f2(f1);
    f2.showShape();
    cout << "Sum of Clone Object : " << f2.getSum() << endl
         << endl;

    int brr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    Figure f3(3, 3, brr);
    f3.showShape();
    cout << "Sum of all elements : " << f3.getSum() << endl;

    return 0;
}