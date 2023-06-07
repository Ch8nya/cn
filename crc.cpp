#include <iostream>
#include <vector>
using namespace std;

vector<bool> crc(vector<bool> frame, vector<bool> gen)
{
    int frame_size = frame.size();
    int gen_size = gen.size();

    for (int i = 0; i < frame_size; i++)
    {
        if (frame[i] == 0)
        {
            continue;
        }
        for (int j = 0; j < gen_size; j++)
        {
            frame[i + j] = frame[i + j] ^ gen[j];
        }
    }
    vector<bool> temp;
    for (int i = frame_size; i < frame_size + gen_size - 1; i++)
    {
        temp.push_back(frame[i]);
    }
    return temp;
}

int main()
{
    int frame_size;
    cout << "Enter frame size: ";
    cin >> frame_size;

    vector<bool> frame;
    cout << "Enter frame bits(space separated)";
    for (int i = 0; i < frame_size; i++)
    {
        bool x;
        cin >> x;
        frame.push_back(x);
    }

    int gen_size;
    cout << "Enter gen size: ";
    cin >> gen_size;

    vector<bool> gen;
    cout << "Enter gen bits(space separated)";
    for (int i = 0; i < gen_size; i++)
    {
        bool x;
        cin >> x;
        gen.push_back(x);
    }

    vector<bool> final_frame(frame);
    final_frame.resize(frame_size + gen_size - 1, 0);

    vector<bool> crc_bits = crc(final_frame, gen);

    cout << "Enter rec frame: ";
    vector<bool> rec_frame;
    for (int i = 0; i < frame_size; i++)
    {
        bool x;
        cin >> x;
        rec_frame.push_back(x);
    }

    rec_frame.insert(rec_frame.end(), crc_bits.begin(), crc_bits.end());
    vector<bool> crc_rec = crc(rec_frame, gen);

    bool error = false;
    for (auto it : crc_rec)
    {
        if (it == 1)
        {
            cout << "Error" << endl;
            error = 1;
            break;
        }
    }
    if (!error)
    {
        cout << "No error" << endl;
    }
    return 0;
}