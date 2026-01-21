#include <iostream>
using namespace std;

class ShiftArray  
{
  int *arr;
  int length;

public:
  ShiftArray(int *array, int size)
  {
    length = size;
    arr = new int[length];
    for (int i = 0; i < length; i++)
    {
      arr[i] = (int)array[i];
    }
  }

  ShiftArray(const ShiftArray &obj)
  {
    length = obj.length;
    arr = new int[length];
    for (int i = 0; i < length; i++)
    {
      arr[i] = obj.arr[i];
    }
  }

  ~ShiftArray()
  {
    delete[] arr;
  }

  ShiftArray operator<<(int n)
  {
    n %= length;
    ShiftArray temp(*this);
    int *tmp = new int[length];

    for (int i = 0; i < length; i++)
    {
      tmp[i] = temp.arr[(i + n) % length];
    }

    for (int i = 0; i < length; i++)
    {
      temp.arr[i] = tmp[i];
    }

    delete[] tmp;
    return temp;
  }

  ShiftArray operator>>(int n)
  {
    n %= length;
    ShiftArray temp(*this);
    int *tmp = new int[length];

    for (int i = 0; i < length; i++)
    {
      tmp[i] = temp.arr[(i - n + length) % length];
    }

    for (int i = 0; i < length; i++)
    {
      temp.arr[i] = tmp[i];
    }

    delete[] tmp;
    return temp;
  }

  ShiftArray &operator<<=(int n)
  {
    n %= length;
    int *tmp = new int[length];

    for (int i = 0; i < length; i++)
    {
      tmp[i] = arr[(i + n) % length];
    }

    for (int i = 0; i < length; i++)
    {
      arr[i] = tmp[i];
    }

    delete[] tmp;
    return *this;
  }

  ShiftArray &operator>>=(int n)
  {
    n %= length;
    int *tmp = new int[length];

    for (int i = 0; i < length; i++)
    {
      tmp[i] = arr[(i - n + length) % length];
    }

    for (int i = 0; i < length; i++)
    {
      arr[i] = tmp[i];
    }

    delete[] tmp;
    return *this;
  }

  ShiftArray &operator=(const ShiftArray &obj)
  {
    if (this != &obj)
    {
      delete[] arr;
      length = obj.length;
      arr = new int[length];
      for (int i = 0; i < length; i++)
      {
        arr[i] = obj.arr[i];
      }
    }
    return *this;
  }

  void Print()
  {
    cout << "[";
    for (int i = 0; i < length; i++)
    {
      cout << arr[i];
      if (i != length - 1)
        cout << ", ";
    }
    cout << "]";
  }
};

int main()
{
  int init[] = {1, 2, 3, 4, 5};
  ShiftArray arr(init, 5);
  // Left shift by 2 positions
  ShiftArray leftShifted = arr << 2;
  cout << "Left shifted by 2: ";
  leftShifted.Print();
  cout << endl;
  // Right shift by 3 positions
  ShiftArray rightShifted = arr >> 3;
  cout << "Right shifted by 3: ";
  rightShifted.Print();
  cout << endl;
  // In-place shifting using compound operators
  arr <<= 1;
  cout << "After <<= 1: ";
  arr.Print();
  cout << endl;
  arr >>= 2;
  cout << "After >>= 2: ";
  arr.Print();
  cout << endl;
  return 0;
}