#include <iostream>
using namespace std;

class Point
{
public:
    double x, y;

    Point(double x = 0, double y = 0) : x(x), y(y) {}

    // Overload + operator to add two points
    Point operator+(const Point &pointObj) const
    {
        return Point(x + pointObj.x, y + pointObj.y);
    }

    // Overload - operator to subtract two points
    Point operator-(const Point &pointObj) const
    {
        return Point(x - pointObj.x, y - pointObj.y);
    }

    // Overload << operator for printing a point
    friend ostream &operator<<(ostream &out, const Point &pointObj);
};

ostream &operator<<(ostream &out, const Point &pointObj)
{
    out << "(" << pointObj.x << ", " << pointObj.y << ")";
    return out;
}

class Vector
{
private:
    Point points[2]; // exactly two points: points[0] = start, points[1] = end

public:
    // Constructors
    Vector() : points{Point(), Point()} {}

    Vector(const Point &start, const Point &end)
    {
        points[0] = start;
        points[1] = end;
    }

    // Accessors
    Point &start() { return points[0]; }
    Point &end() { return points[1]; }

    const Point &start() const { return points[0]; }
    const Point &end() const { return points[1]; }

    // Overload + operator to add two vectors (point-wise)
    Vector operator+(const Vector &vectorObj) const
    {
        return Vector(start() + vectorObj.start(), end() + vectorObj.end());
    }

    // Overload - operator to subtract two vectors (point-wise)
    Vector operator-(const Vector &vectorObj) const
    {
        return Vector(start() - vectorObj.start(), end() - vectorObj.end());
    }

    // Overload * operator for scalar multiplication (Vector * scalar)
    friend Vector operator*(const Vector &vectorObj, int n);

    // Overload * operator for scalar multiplication (scalar * Vector)
    friend Vector operator*(int n, const Vector &vectorObj);

    // Overload subscript operator for const access
    Point &operator[](int n)
    {
        return points[n];
    }
    const Point &operator[](int n) const
    {
        return points[n];
    }

    // Overload << operator for printing a vector
    friend ostream &operator<<(ostream &out, const Vector &vectorObj);
};

Vector operator*(const Vector &vectorObj, int n)
{
    Point point1(vectorObj.start().x * n, vectorObj.start().y * n);
    Point point2(vectorObj.end().x * n, vectorObj.end().y * n);
    return Vector(point1, point2);
}

Vector operator*(int n, const Vector &vectorObj)
{
    return vectorObj * n;
}

ostream &operator<<(ostream &out, const Vector &vectorObj)
{
    out << vectorObj.end().x - vectorObj.start().x << "i + " << vectorObj.end().y - vectorObj.start().y << "j";
    return out;
}

int main()
{
    Point p1(1, 2), p2(3, 4);
    Point p3(5, 6), p4(7, 8);

    Vector v1(p1, p2);
    Vector v2(p3, p4);

    cout << "v1: " << v1 << endl;

    cout << "Start point v1[0]: " << v1[0] << endl;
    cout << "End point v1[1]: " << v1[1] << endl
         << endl;

    cout << "v2: " << v2 << endl;

    cout << "Start point v2[0]: " << v2[0] << endl;
    cout << "End point v2[1]: " << v2[1] << endl
         << endl;

    cout << "v1 + v2 = " << (v1 + v2) << endl;

    cout << "v1 - v2 = " << (v1 - v2) << endl;

    cout << "v1 * 2 = " << (v1 * 2) << endl;

    cout << "10 * v2 = " << (10 * v2) << endl;

    return 0;
}