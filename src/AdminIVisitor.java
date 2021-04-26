import java.util.ArrayList;

public class AdminIVisitor implements IVisitor {

	/**
	 * 
	 * @param route
	 */
	public void visit(Route route) {
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
		for (int i = 0; i < sectionReserved.length; i++) {
			sectionSplit[i] = "|" + sectionID[i] + "(" + sectionReserved[i] + "/" + sectionMax[i] + ")" + sectionPrice[i] ;
		}
		String flight = route.getStartHubID() + "-" + route.getEndHubID() + ":[" + route.getCompanyID().getName() + "]" +
				 route.getRouteID() + "(" + route.getDateDebut() + "-" + route.getDateFin()
				+ ")";

		String together = "";
		for (int i = 0; i < sections.size(); i++) {
			together += sectionSplit[i];
		}

		flight+= together;
		System.out.println(flight);

	}

	@Override
	public void visit(Route route, char classID) {

	}
}