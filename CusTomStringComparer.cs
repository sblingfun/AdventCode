class CustomStringComparer : IComparer<string>
{
    /*
    private readonly IComparer<string> _baseComparer;
    public CustomStringComparer(IComparer<string> baseComparer)
    {
        _baseComparer = baseComparer;
    }

    public int Compare(string x, string y)
    {
        if (_baseComparer.Compare(x, y) == 0)
            return 0;

        // "b" comes before everything else
        if (_baseComparer.Compare(x, "b") == 0)
            return -1;
        if (_baseComparer.Compare(y, "b") == 0)
            return 1;

        // "c" comes next
        if (_baseComparer.Compare(x, "c") == 0)
            return -1;
        if (_baseComparer.Compare(y, "c") == 0)
            return 1;

        return _baseComparer.Compare(x, y);
    }
    */
    public const string Order = "TJQKA";
    public int Compare(string x, string y)
    {
        if (x == null || y == null) {
            return 0;
        }
        for (int i = 0; i < x.Length; i++) {
            int i1;
            int i2;
            if (!int.TryParse(x[i].ToString(),out i1)) {
                i1 = Order.IndexOf(x[i]) + 10;
            } 
            if (!int.TryParse(y[i].ToString(), out i2)) {
                i2 = Order.IndexOf(y[i]) + 10;   
            }

            if (i1 > i2) return 1;
            if (i1 < i2) return -1;
            


        }
        return 0;       
    } 

}