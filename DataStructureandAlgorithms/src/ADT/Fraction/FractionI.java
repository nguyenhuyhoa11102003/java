package ADT.Fraction;

public interface FractionI {
	public int getNumer();

	public int getDenom();

	public void setNumer(int numer);

	public void setDenom(int denom);

	public FractionI add(FractionI f); // returns this + f

	public FractionI minus(FractionI f); // returns this - f

	public FractionI times(FractionI f); // returns this * f

	public FractionI simplify(); // returns this simplified
}
