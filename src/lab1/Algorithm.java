package lab1;


public class Algorithm {
        private int[] key = null;


        public void SetKey(String[] _key)
        {
            key = new int[_key.length];

            for (int i = 0; i < _key.length; i++)
                key[i] =Integer.parseInt(_key[i]);
        }

        public void SetKey(String _key)
        {
            SetKey(_key.split(" "));
        }

        public String Encrypt(String input)
        {
            StringBuilder inputBuilder = new StringBuilder(input);
            for (int i = 0; i < inputBuilder.length() % key.length; i++){
                inputBuilder.append(inputBuilder.toString().charAt(i));
            }
            input = inputBuilder.toString();

            StringBuilder result = new StringBuilder();

            for (int i = 0; i < input.length(); i += key.length)
            {
                char[] transposition = new char[key.length];

                for (int j = 0; j < key.length; j++)
                    transposition[key[j] - 1] = input.charAt(i + j);

                for (int j = 0; j < key.length; j++)
                    result.append(transposition[j]);
            }

            return result.toString();
        }

        public String Decrypt(String input)
        {
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < input.length(); i += key.length)
            {
                char[] transposition = new char[key.length];

                for (int j = 0; j < key.length; j++)
                    transposition[j] = input.charAt(i + key[j] - 1);

                for (int j = 0; j < key.length; j++)
                    result.append(transposition[j]);
            }

            return result.toString();
        }

}
