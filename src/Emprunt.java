import java.util.Date;




public class Emprunt {
	 private Date date_debut;
	 private Date date_fin;
	
	public Emprunt(Date date_debut, Date date_fin) {
		super();
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public float delai(Date d1,Date d2)
	{
		float res=0;
		if(d2.compareTo(d1)==1)
		{
		long diff = d2.getTime()-d1.getTime();
		 res = (diff / (1000*60*60*24));
		}
		return res;
	}
	 
}
