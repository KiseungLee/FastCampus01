package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Problem10814
{
	public static void main(String[] args) throws FileNotFoundException
	{
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. 백준 문제\\java\\BaekJoon\\src\\Solution\\input.txt");
	    Scanner sc = new Scanner(file);		
	    
		int n = sc.nextInt();
		
		Person[] arr = new Person[n];
		
		for (int i = 0; i < n; i++)
		{
			int age = sc.nextInt();
			String name= sc.next();
			Person person = new Person(age, name);
			arr[i] = person;
		}
		
		Arrays.sort(arr, new Comparator<Person>()
		{
			@Override
			public int compare(Person o1, Person o2)
			{
				if(o1.age>o2.age)
					return 1;
				else if(o1.age==o2.age)
					return 0;
				else
					return -1;
			}
		});
		
		for (Person person : arr)
		{
			System.out.println(person.age + " " + person.name);
		}
	}
}

class Person{
	int age;
	String name;
	Person(){
		
	}
	Person(int age, String name){
		this.age = age;
		this.name = name;
	}
}
