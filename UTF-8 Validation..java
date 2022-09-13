class Solution {
    public boolean validUtf8(int[] data)
    {
        int remByte = 0;
        for(int i=0;i<data.length;i++)
        {
            if(remByte==0)
            {
                 if((data[i] >> 7) == 0b0) //1 byte
                 {
                     remByte = 0;    
                 }
                 else if((data[i] >> 5) == 0b110) // 2 byte
                 {
                     remByte = 1;
                 }
                 else if((data[i] >> 4) == 0b1110) // 3 byte
                 {
                     remByte = 2;
                 }
                 else if((data[i] >> 3) == 0b11110) // 4 byte
                 {
                     remByte = 3;
                 }
                 else// if an intger does not start with {0,110,1110,11110}
                 {
                     return false;
                 }
            }
            else
            {
                if((data[i] >> 6) == 0b10)
                {
                    remByte--;
                }
                else
                {
                    return false;
                }
            }
        }
        if(remByte!=0)
            return false;
        else
            return true;
    }
}
