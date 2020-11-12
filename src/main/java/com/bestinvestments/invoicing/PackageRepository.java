package com.bestinvestments.invoicing;

public interface PackageRepository {

   void save(Package p);

   public Package get(PackageReference reference);
}
