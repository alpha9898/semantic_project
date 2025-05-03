package com.example.football_team;

import java.io.InputStream;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;

public class Main {

    public static void main(String[] args) {
        try {
            ClassLoader classLoader = Main.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("RES.owl");

            if (inputStream == null) {
                throw new IllegalArgumentException("File ontology.owl not found in resources");
            }

            OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
            OWLOntology ontology = manager.loadOntologyFromOntologyDocument(inputStream);

            System.out.println("Ontology Loaded: " + ontology.getOntologyID());

            System.out.println("\nClasses in the ontology:");
            for (OWLClass cls : ontology.getClassesInSignature()) {
                System.out.println(" * " + cls.getIRI().getShortForm());
            }
            System.out.println("-------------------------------------------------------");

            System.out.println("\nIndividuals in the ontology:");
            for (OWLNamedIndividual individual : ontology.getIndividualsInSignature()) {
                individual.getEntityType();
                System.out.println(" * " + individual.getIRI().getShortForm());
            }

            OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
            OWLReasoner reasoner = reasonerFactory.createReasoner(ontology);
            reasoner.precomputeInferences();
            System.out.println("-------------------------------------------------------");
            System.out.println("\nObject Properties in the ontology:");
            for (OWLObjectProperty property : ontology.getObjectPropertiesInSignature()) {
                System.out.println(" * " + property.getIRI().getShortForm());
            }

            System.out.println("-------------------------------------------------------");

            System.out.println("\nData Properties in the ontology:");
            for (OWLDataProperty property : ontology.getDataPropertiesInSignature()) {
                System.out.println(" * " + property.getIRI().getShortForm());
            }
            System.out.println("-------------------------------------------------------");

            System.out.println("\nRules in the ontology:");
            for (SWRLRule rule : ontology.getAxioms(AxiomType.SWRL_RULE)) {
                System.out.println(" * " + rule);
            }
            System.out.println("-------------------------------------------------------");
            System.out.println("\nIs ontology consistent? " + reasoner.isConsistent());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}