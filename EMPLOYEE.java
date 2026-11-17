package cinebook;

 interface EMPLOYEE {
	void work();

}
 interface TEACHER {
	void work();

}
class student implements TEACHER,EMPLOYEE{
	public void work(){
	 System.out.println("teacher is an employee who teachers"); }
 
 public static void main(String [] args) {
	 EMPLOYEE e = new student();
	 e.work();
 }
}