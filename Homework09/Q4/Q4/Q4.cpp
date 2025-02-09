#include "Q4.h"
// constructing atomics
#include <iostream>       // std::cout
#include <atomic>         // std::atomic, std::atomic_flag, ATOMIC_FLAG_INIT
#include <thread>         // std::thread, std::this_thread::yield
#include <vector>         // std::vector

std::atomic<short> ready(1);
std::atomic_flag winner = ATOMIC_FLAG_INIT;

void count1m(int id) {
    while (ready == 1) { std::this_thread::yield(); }      // wait for the ready signal
    for (volatile int i = 0; i < 1000000; ++i) {}          // go!, count to 1 million
    if (!winner.test_and_set()) { std::cout << "thread #" << id << " won!\n"; }
};

int main()
{
    std::vector<std::thread> threads;
    std::cout << "spawning 10 threads that count to 1 million...\n";
    for (int i = 1; i <= 10; ++i) threads.push_back(std::thread(count1m, i));
    ready = 0;
    for (auto& th : threads) th.join();

    return 0;
}