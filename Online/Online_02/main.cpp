#include <iostream>
using namespace std;

class Song
{
    string title;
    string artist;
    int duration;

public:
    Song()
    {
        title = "";
        artist = "";
        duration = 0;
    }
    Song(string tittle, string contributor, int length)
    {
        title = tittle;
        artist = contributor;
        duration = length;
    }
    void display()
    {
        cout << "Title: " << title << " " << "Artist: " << artist << " " << "Duration: " << duration << "s" << endl;
    }
    string getTitle()
    {
        return title;
    }
    void setDuration(int dr)
    {
        duration = dr;
    }
    int getDuration()
    {
        return duration;
    }
};

class Playlist
{
    int numSongs;
    int capacity;
    Song *songs;

public:
    Playlist(int capa)
    {
        numSongs = 0;
        capacity = capa;
        songs = new Song[capacity];
    }

    Playlist(const Playlist &pl)
    {

        numSongs = pl.numSongs;
        capacity = pl.capacity;
        songs = new Song[capacity];
        for (int i = 0; i < numSongs; i++)
        {
            songs[i] = pl.songs[i];
        }
    }
    void addSong(Song s)
    {
        if (numSongs >= capacity)
        {
            cout << "No Space left !" << endl;
        }
        else
            songs[numSongs++] = s;
    }
    void updateDuration(string title, int newDuration)
    {
        for (int i = 0; i < numSongs; i++)
        {
            if (songs[i].getTitle() == title)
            {
                songs[i].setDuration(newDuration);
            }
        }
    }
    Song getLongestSong()
    {
        int count = 0;
        int max = 0;
        for (int i = 0; i < numSongs; i++)
        {
            if (songs[i].getDuration() > max)
            {
                max = songs[i].getDuration();
                count = i;
            }
        }
        return songs[count];
    }
    void showList()
    {
        for (int i = 0; i < numSongs; i++)
        {
            songs[i].display();
        }
    }
    ~Playlist()
    {
        delete[] songs;
    }
};

int main()
{
    Playlist p1(4);
    Song s1("Oniket Prantor", "Artcell", 982);
    Song s2("Obak Bhalobasha", "Warfaze", 354);
    Song s3("Boshonto Batashe", "James", 285);
    p1.addSong(s1);
    p1.addSong(s2);
    p1.addSong(s3);
    cout << "Playlist 1 (Original):\n";
    p1.showList();
    // Test Copy Constructor (Deep Copy)
    Playlist p2 = p1;
    // Modify p2: Radio Edit for Oniket Prantor, and add new song
    p2.updateDuration("Oniket Prantor", 300);
    p2.addSong(Song("Alo", "Tahsan", 250));
    cout << "\nPlaylist 1 Longest Song:\n";
    p1.getLongestSong().display(); // Should remain Oniket Prantor (982s)
    cout << "\nPlaylist 2 (Modified):\n";
    p2.showList();
    cout << "\nPlaylist 2 Longest Song:\n";
    p2.getLongestSong().display(); // Should now be Obak Bhalobasha (354s)
    return 0;
}