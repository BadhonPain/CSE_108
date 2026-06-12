#include <iostream>
#include <string>
#include <iomanip>
#include <fstream> // for file handling

using namespace std;

//**************** ****************************************************************** **********************/
//**************** 'Cricketer' class represents a general cricketer. Do not change!!! **********************/
//****************   You can not add any other properties or methods in any classes   **********************/
//**************** ****************************************************************** **********************/
class Cricketer
{
protected:
    int matchPlayed;
    string name;
    int age;

public:
    // constructor to initialize name, age, and matches played
    Cricketer(string s = "Unknown", int a = 0, int m = 0) : name(s), age(a), matchPlayed(m) {}

    string getName() { return name; }
    int getMatchPlayed() { return matchPlayed; }
    int getAge() { return age; }
    void setName(string n) { name = n; }
    void setAge(int a) { age = a; }
    void setMatchPlayed(int m) { matchPlayed = m; }

    // Prints basic cricketer info
    virtual void printInfo(ofstream &out)
    {
        out << "Name: " << name << ", Age: " << age << ", Matches Played: " << matchPlayed << endl;
    }

    virtual ~Cricketer() {}
};

//**************** ****************************************************************** **********************/
//**************** ****************************************************************** **********************/

// 'Batsman' class represents a batsman
// Inherit 'Cricketer' class to implement 'Batsman'
class Batsman : public Cricketer
{
protected:
    int runScored;
    int ballsFaced;

public:
    // Implement Constructor to initialize batting details along with cricketer data
    // Take Name, Age, Matches played, Runs, Balls
    Batsman(){}
    Batsman(string name, int age, int matchPlayed, int runs, int balls)
    {
        Cricketer(name, age, matchPlayed);
        runScored = runs;
        ballsFaced = balls;
    }

    // Compute batting average: runs/matches
    double computeBattingAverage()
    {
        return runScored / double(this->getMatchPlayed());
    }

    // Compute strike rate: (runs/balls faced) * 100
    double computeStrikeRate()
    {
        return (runScored / double(ballsFaced)) * 100;
    }

    // Getter & Setter for total runs
    int getRuns()
    {
        return runScored;
    }
    // Getter & Setter for balls faced
    int getBallFaced()
    {
        return ballsFaced;
    }

    // Print batsman-specific stats; you have to use the base class's method here.
    void printInfo(ofstream &out)
    {
        out << "Run Scored: " << runScored << ", Balls Faced: " << ballsFaced << "\nBatting Average: " << computeBattingAverage() << ", Strike Rate: " << computeStrikeRate() << endl;
    }
};

// 'Bowler' class represents a bowler
// Inherit 'Cricketer' class to implement 'Bowler'
class Bowler : public Cricketer
{
protected:
    int wicketsTaken;
    int runsConceded;
    double oversBowled;

public:
    // Implement Constructor to initialize bowling details along with cricketer data
    // Take Name, Age, Matches played, Wickets, RunsConceded, Overs
    Bowler(){}
    Bowler(string name, int age, int matchesPlayed, int wickets, int runsConceded, int overs)
    {
        Cricketer(name, age, matchesPlayed);
        wicketsTaken = wickets;
        this->runsConceded = runsConceded;
        oversBowled = overs;
    }

    // Compute average wickets per match
    double computeWicketAverage()
    {
        return wicketsTaken / double(matchPlayed);
    }

    // Compute economy rate: runs conceded per over
    double computeEconomy()
    {
        return runsConceded / double(oversBowled);
    }

    // Getter & Setter for wickets
    int getWickets()
    {
        return wicketsTaken;
    }
    // Getter & Setter for runs conceded
    int getRunsConceded()
    {
        return runsConceded;
    }
    // Getter & Setter for overs bowled
    int getOvers()
    {
        return oversBowled;
    }

    // Print bowler-specific stats; you have to use the base class's method here.
    void printInfo(ofstream &out)
    {
        out << "Wickets Taken: " << wicketsTaken << ", Runs Conceded: " << runsConceded << ", Overs Bowled: " << oversBowled << endl;
    }
};

// The following class represents an allrounder (inherits from both Batsman and Bowler)
class Allrounder : public Batsman, public Bowler
{
public:
    // Implement Constructor to initialize all data for an allrounder (batsman and bowler)
    Allrounder(string name,int age, int matchesPlayed,int runsScored, int ballsFaced, int wicketsTaken, int runConceded, int overs)
    {
        Batsman(name,age,matchesPlayed,runsScored,ballsFaced);
        Bowler(name,age,matchesPlayed,wicketsTaken,runConceded,overs);
    }

    // Print both batting and bowling statistics; you have to use the base class's method here.
    void printInfo();
};

// input file style
// TYPE Name Age Matches Runs Balls Wickets RunsConceded Overs

int main()
{
    // You have to take input from "input1.txt" and you have to generate an "output.txt" file like "Demo_output.txt"
    // First take the players information from "input.txt" and create necessary player objects
    // Then save them in an array of players
    // Finally, show the players' information
    // NOTE: Players can be of any type

    return 0;
}
