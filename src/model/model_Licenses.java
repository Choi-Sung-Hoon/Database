package model;

public class model_Licenses
{
	private String license_name;

	public model_Licenses(String license_name)
	{
		this.setLicenseName(license_name);
	}
	
	public String getLicenseName()
	{
		return license_name;
	}

	public void setLicenseName(String license_name)
	{
		this.license_name = license_name;
	}
	
	@Override
	public String toString()
	{
		return "Licenses[license_name=" + getLicenseName() + "]";
	}
}
