import java.util.Scanner;
class Graph{
    private String vertex[]={"Mohave","Coconio","Navajo","Apache","Greenlee","Cochise","Santa Cruz","Pima","Pinal","Graham","Gila","Yavapai","La Paz","Yuma","Maricopa"};
    private final int rows;
    private final int cols;
    private int incMat[][];
    //constructor to assign values to rows and columns
    Graph(){
        rows=15;
        cols=15;
        incMat=new int [rows][cols];
    }
	//method to add an edge in the graph
	public void createEdge(int to_vertex,int from_vertex,int edge){
		if(to_vertex>rows || from_vertex>cols){
			throw new ArrayIndexOutOfBoundsException("You can't enter vertex more than"+rows);
		}else
		{	
			incMat[to_vertex][from_vertex]=edge;
			incMat[from_vertex][to_vertex]=edge;
		}
	}
	
	//method to print Adjancy Matrix
	public void printMatrix(){
		for(int i=1;i<rows;i++)
			System.out.print("\t"+i);
		System.out.println();
		for(int i=1;i<rows;i++){
			System.out.print(" "+i);
			for(int j=1;j<rows;j++){
				System.out.print("\t"+getEdge(i,j));
			}
			System.out.println();
		}
		
	}
	
	//method to get neighbour vertex
	public void printNeighbourVertex(int vertex){
		for(int i=1;i<rows;i++){
			int temp=getEdge(vertex,i);
			if(temp==1)
				System.out.println(i+"is neighbour vertex of"+vertex);
		}
	}
	//method to get an Edge
	private int getEdge(int v1,int v2){
		
			if(incMat[v1][v2]>0)
				return 1;
			else 
				return 0;
		
	}
	//method to get Index of Vertices
	private int getIndex(String v){
		for(int i=0;i<vertex.length;i++){
			if(vertex[i].equals(v))
				return i;
		}
		return -1;
	}


		
		 //enable this method if you want to get Distance using integer value of vertex
		public void getDistance(int vertex1,int vertex2){
			
			if(vertex1<0 || vertex2<0){
				System.out.println("vertex doesn't exist");
				return;
			}
			if(incMat[vertex1][vertex2]>0 || incMat[vertex2][vertex1]>0){
				System.out.println("weight is:-"+incMat[vertex1][vertex2]);
			}else
				System.out.println("Edge doesn't exist");
		 }
    public static void main(String args[]){ 
        
        Graph graph=new Graph();//creating an object of class graph		
        Scanner scan=new Scanner(System.in);

		graph.createEdge(12,0,9);
		graph.createEdge(12,11,15);
		graph.createEdge(12,14,15);
		graph.createEdge(12,13,11);
		graph.createEdge(13,14,18);
		graph.createEdge(13,7,23);
		graph.createEdge(14,11,9);
		graph.createEdge(14,10,8);
		graph.createEdge(14,8,6);
		graph.createEdge(14,7,10);
		graph.createEdge(11,0,4);
		graph.createEdge(11,10,18);
		graph.createEdge(11,1,9);
		graph.createEdge(0,1,14);
		graph.createEdge(1,2,9);
		graph.createEdge(1,10,17);
		graph.createEdge(2,10,13);
		graph.createEdge(2,3,5);
		graph.createEdge(2,9,20);
		graph.createEdge(3,9,19);
		graph.createEdge(3,4,17);
		graph.createEdge(4,9,4);
		graph.createEdge(4,5,16);
		graph.createEdge(5,9,12);
		graph.createEdge(5,7,9);
		graph.createEdge(5,6,8);
		graph.createEdge(6,7,6);
		graph.createEdge(7,8,7);
		graph.createEdge(8,10,5);
		graph.createEdge(8,9,13);
		graph.createEdge(9,7,12);
		graph.createEdge(10,9,7);
		graph.printMatrix();
		int ch;
		do{
			System.out.println("enter 1 to find neighbour vertex\nenter 2 to find weight of an edge\n");
			int choice=scan.nextInt();
			switch(choice){
				case 1:
					System.out.println("Enter vertex which neighbour you want to know");
					int v=scan.nextInt();
					graph.printNeighbourVertex(v);
					break;
				case 2:
					int str1,str2;
					scan.nextLine();
					System.out.println("Enter vertex 1");
					str1=scan.nextInt();
					System.out.println("Enter vertex 2");
					str2=scan.nextInt();
					graph.getDistance(str1,str2);
			}
			System.out.println("Enter '1' to continue\n Enter '0' to break");
			ch=scan.nextInt();
			if(ch==0)
				break;
		}while(ch==1);
    }
}
