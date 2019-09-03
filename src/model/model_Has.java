package model;

public class model_Has
{
   private String id;
   private String license_name;
   private int score;
   
   public model_Has (String id, String license_name, int score)
   {
      this.setId(id);
      this.setLicenseName(license_name);
      this.setScore(score);
   }
   
   public String getId()
   {
      return id;
   }

   public void setId(String id)
   {
      this.id = id;
   }

   public String getLicenseName()
   {
      return license_name;
   }

   public void setLicenseName(String license_name)
   {
      this.license_name = license_name;
   }

   public int getScore()
   {
      return score;
   }

   public void setScore(int score)
   {
      this.score = score;
   }
   
   @Override
   public String toString()
   {
      return "Has[id=" + getId() + ", license_name=" + getLicenseName() + ", score=" + getScore() + "]";
   }
}