package extendsome;

public class Main implements Football{
	public String gohome;
	public int homepos;
	
	public void getMySelfField(){
		this.gohome = "12312";
		this.homepos = 12;
	}
	
	@Override
	public void setHomeTeam(String name) {
		// TODO Auto-generated method stub
		System.out.println(1);
	}

	@Override
	public void setVisitingTeam(String name) {
		// TODO Auto-generated method stub
		System.out.println(2);
	}

	@Override
	public void homeTeamScored(int points) {
		// TODO Auto-generated method stub
		System.out.println(3);
	}

	@Override
	public void visitingTeamScored(int points) {
		// TODO Auto-generated method stub
		System.out.println(3);
	}

	@Override
	public void endOfQuarter(int quarter) {
		// TODO Auto-generated method stub
		System.out.println(4);
	}
	
	public static void main(String[] args){
		Main m = new Main();
		m.setHomeTeam("");
		m.setVisitingTeam("");
		m.visitingTeamScored(1);
		m.endOfQuarter(1);
		m.getMySelfField();
	}
}
