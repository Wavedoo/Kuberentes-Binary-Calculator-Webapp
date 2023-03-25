package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary
{
	private String number="0";  // string containing the binary value '0' or '1'
	/**
	 * A constructor that generates a binary object.
	 *
	 * @param number a String of the binary values. It should conatins only zeros or ones with any length and order. otherwise, the value of "0" will be stored.   Trailing zeros will be excluded and empty string will be considered as zero.
	 */
	public Binary(String number) {
		for (int i = 0; i < number.length(); i++) {
			// check each character if it's not 0 or 1
			char ch=number.charAt(i);
			if(ch!='0' && ch!='1') {
				number="0"; // if not store "0" and end the function
				return;
			}
		}
		// remove any trailing zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg)!='0')
				break;
		}
		//beg has the index of the first non zero digit in the number
		this.number=number.substring(beg); // exclude the trailing zeros if any
		// uncomment the following code

		if(this.number=="") { // replace empty strings with a single zero
			this.number="0";
		}

	}
	/**
	 * Return the binary value of the variable
	 *
	 * @return the binary value in a string format.
	 */
	public String getValue()
	{
		return this.number;
	}
	/**
	 * Adding two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers </a>.
	 *
	 * @param num1 The first addend object
	 * @param num2 The second addend object
	 * @return A binary variable with a value of <i>num1+num2</i>.
	 */
	public static Binary add(Binary num1,Binary num2)
	{
		// the index of the first digit of each number
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;
		//initial variable
		int carry=0;
		String num3="";  // the binary value of the sum
		while(ind1>=0 ||  ind2>=0 || carry!=0) // loop until all digits are processed
		{
			int sum=carry; // previous carry
			if(ind1>=0){ // if num1 has a digit to add
				sum += (num1.number.charAt(ind1)=='1')? 1:0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if(ind2>=0){ // if num2 has a digit to add
				sum += (num2.number.charAt(ind2)=='1')? 1:0; // convert the digit to int and add it to sum
				ind2--; //update ind2
			}
			carry=sum/2; // the new carry
			sum=sum%2;  // the resultant digit
			num3 =( (sum==0)? "0":"1")+num3; //convert sum to string and append it to num3
		}
		Binary result=new Binary(num3);  // create a binary object with the calculated value.
		return result;

	}
	/**
	 * Returns the or value of two  binary variables. For more information, visit <a href="https://learn.sparkfun.com/tutorials/binary/bitwise-operators#:~:text=Bitwise%20operators%20perform%20functions%20bit,throughout%20both%20electronics%20and%20programming."> Bitwise operators on binary numbers </a>.
	 *
	 * @param num1 The first or object
	 * @param num2 The second or object
	 * @return A binary variable with a value of <i>num1 or num2</i>.
	 */
	public static Binary or(Binary num1,Binary num2)
	{
		// the index of the first digit of each number
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;
		//initial variable
		int digit;
		String num3="";  // the binary value of the sum
		while(ind1>=0 ||  ind2>=0) // loop until all digits are processed
		{
			digit = 0;
			if(ind1>=0){ // if num1 has a digit to or
				if(num1.number.charAt(ind1) == '1') //If the digit at ind1 is 1 then set digit to 1
					digit = 1;
				ind1--; // update ind1
			}
			if(ind2>=0){ // if num2 has a digit to or
				if(num2.number.charAt(ind2) == '1') //If the digit at ind2 is 1 then set digit to 1
					digit = 1;
				ind2--; //update ind2
			}
			num3 =((digit==0)? "0":"1")+num3; //convert sum to string and append it to num3
		}
		Binary result=new Binary(num3);  // create a binary object with the calculated value.
		return result;
	}
	/**
	 * Returns the and value of two  binary variables. For more information, visit <a href="https://learn.sparkfun.com/tutorials/binary/bitwise-operators#:~:text=Bitwise%20operators%20perform%20functions%20bit,throughout%20both%20electronics%20and%20programming."> Bitwise operators on binary numbers </a>.
	 *
	 * @param num1 The first and object
	 * @param num2 The second and object
	 * @return A binary variable with a value of <i>num1 and num2</i>.
	 */
	public static Binary and(Binary num1,Binary num2)
	{
		// the index of the first digit of each number
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;
		//initial variable
		int digit;
		String num3="";  // the binary value of the sum
		while(ind1>=0 && ind2>=0) // loop until the smaller binary value's digits have been processed
		{
			// Make digit 1 if both digits are 1
			digit = (num1.number.charAt(ind1)=='1' && num2.number.charAt(ind2)=='1')? 1:0;
			ind1--; // update ind1
			ind2--;// update ind2
			num3 =( (digit==0)? "0":"1")+num3; //convert sum to string and append it to num3
		}
		Binary result=new Binary(num3);  // create a binary object with the calculated value.
		return result;
	}
	/**
	 * Multiplying two binary variables. For more information, visit <a href="https://www.cuemath.com/numbers/binary-multiplication/"> Binary Multiplication </a>.
	 *
	 * @param num1 The multiplier object
	 * @param num2 The multiplicand object
	 * @return A binary variable with a value of <i>num1 × num2</i>.
	 */
	public static Binary multiply(Binary num1,Binary num2)
	{
		// the index of the first digit of each number
		int ind1=num1.number.length()-1;
		//initial variable
		Binary partialSum = new Binary("0");
		int extraZeros = 0; //Value to hold the extra zeroes a value might have.
		while(ind1>=0){ //Process each digit in the multiplier
			//Skip current digit if it is 0
			if (num1.number.charAt(ind1) == '0'){
				ind1--;
				extraZeros++;
				continue;
			}

			//Make a string of zeroes to add to the multiplicand
			String zeroes = "";
			for (int i = 0; i < extraZeros; i++){
				zeroes += "0";
			}
			//Gets a binary temp value representing the number to add to the partial sum and adds it
			Binary temp = new Binary(num2.getValue() + zeroes);
			partialSum = Binary.add(partialSum, temp);

			extraZeros++; //Increases number of zeroes
			ind1--; //Updates ind1
		}
		Binary result=new Binary(partialSum.getValue());
		return result;
	}
}