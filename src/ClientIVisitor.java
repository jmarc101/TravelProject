import java.util.ArrayList;

public class ClientIVisitor implements IVisitor {

	@Override
	public void visit(Route route) {
		System.out.println("\n*** Flight ID : " + route.getRouteID());
		ArrayList<Section> sections = route.getVehicle().getSections();
		int[] sectionReserved = new int[sections.size()];
		char[] sectionID = new char[sections.size()];
		int[] sectionMax = new int[sections.size()];
		double[] sectionPrice = new double[sections.size()];
		String[] sectionSplit = new String[sections.size()];
		for (int i = 0; i < sections.size(); i++) {
			int reserved = 0;
			for (Seat seat : sections.get(i).getSeats()) {
				if (!seat.isAvailable()) reserved++;
			}
			sectionReserved[i] = reserved;
			sectionID[i] = sections.get(i).sectionClass.getId();
			sectionMax[i] = sections.get(i).sectionClass.getMaxCapacity();
			sectionPrice[i] = sections.get(i).getPrice();
		}

		String flight = route.getStartHubID() + "-" + route.getEndHubID() + ":[" + route.getCompanyID().getName() + "]" +
				route.getRouteID() + "(" + route.getDateDebut() + "-" + route.getDateFin()
				+ ")";
		for (int i = 0; i < sectionReserved.length; i++) {
			sectionSplit[i] = flight + "|" + sectionID[i] + "(" + sectionReserved[i] + "/" + sectionMax[i] + ")" + sectionPrice[i] ;
		}

		for (int i = 0; i < sectionSplit.length; i++) {

			switch (sectionID[i]){
				case 'F':
					System.out.print("First Class : ");
					break;
				case 'E':
					System.out.print("Economy Class : ");
					break;
				case 'D':
					System.out.print("Business Class : ");
					break;
				case 'P':
					System.out.print("Premium Class : ");
					break;
			}
			System.out.println(sectionSplit[i]);
		}

	}

}