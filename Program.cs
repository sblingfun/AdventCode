using System.Collections;
using System.Diagnostics;
using System.Diagnostics.Contracts;
using System.IO;

class Program {
    static void Main(string[] args)
    {
        try
        {
            string path = Directory.GetCurrentDirectory();
            path = Directory.GetParent(path).FullName;
            path = Directory.GetParent(path).FullName;
            path = Directory.GetParent(path).FullName;
            path = Directory.GetParent(path).FullName;
            path = Directory.GetParent(path).FullName;
            //Console.WriteLine(path);
            string fullPath = $"{path}\\Day7Input.txt";
            //string fullPath = $"{path}\\Day7InputTEST.txt";

            StreamReader sr = new StreamReader(fullPath);

            List<int> betList = new List<int>();
            List<string> handList = new List<string>();

            string curLine = sr.ReadLine();
            while (curLine != null) {
                //Console.WriteLine(curLine);
                string[] lineSplit = curLine.Split(" ", StringSplitOptions.RemoveEmptyEntries);
                /*
                foreach (var split in lineSplit) {
                    Console.WriteLine(split);
                }
                */
                handList.Add(lineSplit[0]);
                betList.Add(Int32.Parse(lineSplit[1]));            
                curLine = sr.ReadLine();
            }
            sr.Close();

            Dictionary<string,int> fiveKind = new Dictionary<string,int>();
            Dictionary<string,int> fourKind = new Dictionary<string,int>();
            Dictionary<string,int> fullHouse = new Dictionary<string,int>();
            Dictionary<string,int> threeKind = new Dictionary<string,int>();
            Dictionary<string,int> twoPair = new Dictionary<string,int>();
            Dictionary<string,int> pair = new Dictionary<string,int>();
            Dictionary<string,int> highC = new Dictionary<string,int>();


            for (int j = 0; j < handList.Count; j++) {
                Dictionary<char,List<int>> cardFreq = new Dictionary<char, List<int>>();
                //Dictionary<char,int> cardFreq = new Dictionary<char, int>();
                string hand = handList[j];
                for (int i = 0; i < hand.Length; i++) {
                    //cardFreq.Add(hand[i],cardFreq.GetValueOrDefault(hand[i], 0) + 1);
                    //cardFreq[hand[i]] = cardFreq.GetValueOrDefault(hand[i], 0) + 1;
                    
                    if (!cardFreq.ContainsKey(hand[i])) {
                        cardFreq[hand[i]] = new List<int>() {1,i};
                    }
                    else {
                        List<int> oldFreq = cardFreq[hand[i]];
                        oldFreq[0] += 1;
                        oldFreq.Add(i); 
                        cardFreq[hand[i]] = oldFreq;
                    }
                }
                int maxFreq = 0;
                foreach (var card in cardFreq) {
                    /*
                    Console.WriteLine();
                    Console.WriteLine(card.Key);
                    foreach (int val in cardFreq[card.Key]) {
                        Console.Write(val + " ");
                    }
                    Console.WriteLine();
                    */
                    maxFreq = Math.Max(maxFreq,card.Value[0]);

                }
                switch (maxFreq) {
                    case 5:
                        //Console.WriteLine("Five of a Kind");
                        fiveKind.Add(handList[j],betList[j]);
                        break;
                    case 4:
                        //Console.WriteLine("Four of a Kind");
                        fourKind.Add(handList[j],betList[j]);
                        break;
                    case 3:
                        if (cardFreq.Count == 2) {
                            //Console.WriteLine("Full House");
                            fullHouse.Add(handList[j],betList[j]);
                        }
                        else {
                            //Console.WriteLine("Three of a Kind");
                            threeKind.Add(handList[j],betList[j]);
                        }
                        break;
                    case 2:
                        if (cardFreq.Count == 3) {
                            //Console.WriteLine("Two Pair");
                            twoPair.Add(handList[j],betList[j]);
                        }
                        else {
                            pair.Add(handList[j],betList[j]);
                            //Console.WriteLine("Pair");
                        }                        
                        break;
                    default:
                        //Console.WriteLine("High Card");
                        highC.Add(handList[j],betList[j]);
                        break;
                }
                

            }

            SortedDictionary<string,int> sortFive = new SortedDictionary<string, int>(fiveKind, new CustomStringComparer());            
            SortedDictionary<string,int> sortFour = new SortedDictionary<string, int>(fourKind, new CustomStringComparer());
            SortedDictionary<string,int> sortHouse = new SortedDictionary<string, int>(fullHouse, new CustomStringComparer());             
            SortedDictionary<string,int> sortThree = new SortedDictionary<string, int>(threeKind, new CustomStringComparer());            
            SortedDictionary<string,int> twoPairSort = new SortedDictionary<string, int>(twoPair, new CustomStringComparer());
            SortedDictionary<string,int> sortPair = new SortedDictionary<string, int>(pair, new CustomStringComparer());            
            SortedDictionary<string,int> sortHigh = new SortedDictionary<string, int>(highC, new CustomStringComparer());
            
            //Console.WriteLine(twoPairSort.Keys.ToList());
            
            List<int> orderedBetList = sortHigh.Values.Concat(sortPair.Values).Concat(twoPairSort.Values).Concat(sortThree.Values).Concat(sortHouse.Values).Concat(sortFour.Values).Concat(sortFive.Values).ToList();
            int totalSum = 0;
            for (int i = 0; i < orderedBetList.Count; i++) {
                Console.WriteLine(orderedBetList[i] + " Idx: " + i + 1);
                int betRet = orderedBetList[i] * (i + 1);
                Console.WriteLine("Adding " + betRet);
                totalSum += betRet;
            }
            //Console.WriteLine(orderedBetList);
            Console.WriteLine("Total Sum: " + totalSum);
            
        }
        catch(Exception e)
        {
            Console.WriteLine("Exception: " + e.Message);
        }
    }
}

