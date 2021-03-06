/*
 * An XML document type.
 * Localname: program
 * Namespace: http://ci.uchicago.edu/swift/2009/02/swiftscript
 * Java type: org.globus.swift.language.ProgramDocument
 *
 * Automatically generated - do not modify.
 */
package org.globus.swift.language;


/**
 * A document containing one program(@http://ci.uchicago.edu/swift/2009/02/swiftscript) element.
 *
 * This is a complex type.
 */
public interface ProgramDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ProgramDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s4846B13C10E24B6C12C8DCBE3348DA75").resolveHandle("programcdd6doctype");
    
    /**
     * Gets the "program" element
     */
    org.globus.swift.language.ProgramDocument.Program getProgram();
    
    /**
     * Sets the "program" element
     */
    void setProgram(org.globus.swift.language.ProgramDocument.Program program);
    
    /**
     * Appends and returns a new empty "program" element
     */
    org.globus.swift.language.ProgramDocument.Program addNewProgram();
    
    /**
     * An XML program(@http://ci.uchicago.edu/swift/2009/02/swiftscript).
     *
     * This is a complex type.
     */
    public interface Program extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Program.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s4846B13C10E24B6C12C8DCBE3348DA75").resolveHandle("program7ce6elemtype");
        
        /**
         * Gets the "imports" element
         */
        org.globus.swift.language.ImportsDocument.Imports getImports();
        
        /**
         * True if has "imports" element
         */
        boolean isSetImports();
        
        /**
         * Sets the "imports" element
         */
        void setImports(org.globus.swift.language.ImportsDocument.Imports imports);
        
        /**
         * Appends and returns a new empty "imports" element
         */
        org.globus.swift.language.ImportsDocument.Imports addNewImports();
        
        /**
         * Unsets the "imports" element
         */
        void unsetImports();
        
        /**
         * Gets the "types" element
         */
        org.globus.swift.language.TypesDocument.Types getTypes();
        
        /**
         * True if has "types" element
         */
        boolean isSetTypes();
        
        /**
         * Sets the "types" element
         */
        void setTypes(org.globus.swift.language.TypesDocument.Types types);
        
        /**
         * Appends and returns a new empty "types" element
         */
        org.globus.swift.language.TypesDocument.Types addNewTypes();
        
        /**
         * Unsets the "types" element
         */
        void unsetTypes();
        
        /**
         * Gets array of all "procedure" elements
         */
        org.globus.swift.language.Procedure[] getProcedureArray();
        
        /**
         * Gets ith "procedure" element
         */
        org.globus.swift.language.Procedure getProcedureArray(int i);
        
        /**
         * Returns number of "procedure" element
         */
        int sizeOfProcedureArray();
        
        /**
         * Sets array of all "procedure" element
         */
        void setProcedureArray(org.globus.swift.language.Procedure[] procedureArray);
        
        /**
         * Sets ith "procedure" element
         */
        void setProcedureArray(int i, org.globus.swift.language.Procedure procedure);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "procedure" element
         */
        org.globus.swift.language.Procedure insertNewProcedure(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "procedure" element
         */
        org.globus.swift.language.Procedure addNewProcedure();
        
        /**
         * Removes the ith "procedure" element
         */
        void removeProcedure(int i);
        
        /**
         * Gets array of all "variable" elements
         */
        org.globus.swift.language.Variable[] getVariableArray();
        
        /**
         * Gets ith "variable" element
         */
        org.globus.swift.language.Variable getVariableArray(int i);
        
        /**
         * Tests for nil ith "variable" element
         */
        boolean isNilVariableArray(int i);
        
        /**
         * Returns number of "variable" element
         */
        int sizeOfVariableArray();
        
        /**
         * Sets array of all "variable" element
         */
        void setVariableArray(org.globus.swift.language.Variable[] variableArray);
        
        /**
         * Sets ith "variable" element
         */
        void setVariableArray(int i, org.globus.swift.language.Variable variable);
        
        /**
         * Nils the ith "variable" element
         */
        void setNilVariableArray(int i);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "variable" element
         */
        org.globus.swift.language.Variable insertNewVariable(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "variable" element
         */
        org.globus.swift.language.Variable addNewVariable();
        
        /**
         * Removes the ith "variable" element
         */
        void removeVariable(int i);
        
        /**
         * Gets array of all "assign" elements
         */
        org.globus.swift.language.Assign[] getAssignArray();
        
        /**
         * Gets ith "assign" element
         */
        org.globus.swift.language.Assign getAssignArray(int i);
        
        /**
         * Returns number of "assign" element
         */
        int sizeOfAssignArray();
        
        /**
         * Sets array of all "assign" element
         */
        void setAssignArray(org.globus.swift.language.Assign[] assignArray);
        
        /**
         * Sets ith "assign" element
         */
        void setAssignArray(int i, org.globus.swift.language.Assign assign);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "assign" element
         */
        org.globus.swift.language.Assign insertNewAssign(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "assign" element
         */
        org.globus.swift.language.Assign addNewAssign();
        
        /**
         * Removes the ith "assign" element
         */
        void removeAssign(int i);
        
        /**
         * Gets array of all "call" elements
         */
        org.globus.swift.language.Call[] getCallArray();
        
        /**
         * Gets ith "call" element
         */
        org.globus.swift.language.Call getCallArray(int i);
        
        /**
         * Returns number of "call" element
         */
        int sizeOfCallArray();
        
        /**
         * Sets array of all "call" element
         */
        void setCallArray(org.globus.swift.language.Call[] callArray);
        
        /**
         * Sets ith "call" element
         */
        void setCallArray(int i, org.globus.swift.language.Call call);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "call" element
         */
        org.globus.swift.language.Call insertNewCall(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "call" element
         */
        org.globus.swift.language.Call addNewCall();
        
        /**
         * Removes the ith "call" element
         */
        void removeCall(int i);
        
        /**
         * Gets array of all "foreach" elements
         */
        org.globus.swift.language.Foreach[] getForeachArray();
        
        /**
         * Gets ith "foreach" element
         */
        org.globus.swift.language.Foreach getForeachArray(int i);
        
        /**
         * Returns number of "foreach" element
         */
        int sizeOfForeachArray();
        
        /**
         * Sets array of all "foreach" element
         */
        void setForeachArray(org.globus.swift.language.Foreach[] foreachArray);
        
        /**
         * Sets ith "foreach" element
         */
        void setForeachArray(int i, org.globus.swift.language.Foreach foreach);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "foreach" element
         */
        org.globus.swift.language.Foreach insertNewForeach(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "foreach" element
         */
        org.globus.swift.language.Foreach addNewForeach();
        
        /**
         * Removes the ith "foreach" element
         */
        void removeForeach(int i);
        
        /**
         * Gets array of all "if" elements
         */
        org.globus.swift.language.If[] getIfArray();
        
        /**
         * Gets ith "if" element
         */
        org.globus.swift.language.If getIfArray(int i);
        
        /**
         * Returns number of "if" element
         */
        int sizeOfIfArray();
        
        /**
         * Sets array of all "if" element
         */
        void setIfArray(org.globus.swift.language.If[] xifArray);
        
        /**
         * Sets ith "if" element
         */
        void setIfArray(int i, org.globus.swift.language.If xif);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "if" element
         */
        org.globus.swift.language.If insertNewIf(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "if" element
         */
        org.globus.swift.language.If addNewIf();
        
        /**
         * Removes the ith "if" element
         */
        void removeIf(int i);
        
        /**
         * Gets array of all "switch" elements
         */
        org.globus.swift.language.Switch[] getSwitchArray();
        
        /**
         * Gets ith "switch" element
         */
        org.globus.swift.language.Switch getSwitchArray(int i);
        
        /**
         * Returns number of "switch" element
         */
        int sizeOfSwitchArray();
        
        /**
         * Sets array of all "switch" element
         */
        void setSwitchArray(org.globus.swift.language.Switch[] xswitchArray);
        
        /**
         * Sets ith "switch" element
         */
        void setSwitchArray(int i, org.globus.swift.language.Switch xswitch);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "switch" element
         */
        org.globus.swift.language.Switch insertNewSwitch(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "switch" element
         */
        org.globus.swift.language.Switch addNewSwitch();
        
        /**
         * Removes the ith "switch" element
         */
        void removeSwitch(int i);
        
        /**
         * Gets array of all "iterate" elements
         */
        org.globus.swift.language.Iterate[] getIterateArray();
        
        /**
         * Gets ith "iterate" element
         */
        org.globus.swift.language.Iterate getIterateArray(int i);
        
        /**
         * Returns number of "iterate" element
         */
        int sizeOfIterateArray();
        
        /**
         * Sets array of all "iterate" element
         */
        void setIterateArray(org.globus.swift.language.Iterate[] iterateArray);
        
        /**
         * Sets ith "iterate" element
         */
        void setIterateArray(int i, org.globus.swift.language.Iterate iterate);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "iterate" element
         */
        org.globus.swift.language.Iterate insertNewIterate(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "iterate" element
         */
        org.globus.swift.language.Iterate addNewIterate();
        
        /**
         * Removes the ith "iterate" element
         */
        void removeIterate(int i);
        
        /**
         * Gets the "targetNamespace" attribute
         */
        java.lang.String getTargetNamespace();
        
        /**
         * Gets (as xml) the "targetNamespace" attribute
         */
        org.apache.xmlbeans.XmlAnyURI xgetTargetNamespace();
        
        /**
         * True if has "targetNamespace" attribute
         */
        boolean isSetTargetNamespace();
        
        /**
         * Sets the "targetNamespace" attribute
         */
        void setTargetNamespace(java.lang.String targetNamespace);
        
        /**
         * Sets (as xml) the "targetNamespace" attribute
         */
        void xsetTargetNamespace(org.apache.xmlbeans.XmlAnyURI targetNamespace);
        
        /**
         * Unsets the "targetNamespace" attribute
         */
        void unsetTargetNamespace();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static org.globus.swift.language.ProgramDocument.Program newInstance() {
              return (org.globus.swift.language.ProgramDocument.Program) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static org.globus.swift.language.ProgramDocument.Program newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (org.globus.swift.language.ProgramDocument.Program) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.globus.swift.language.ProgramDocument newInstance() {
          return (org.globus.swift.language.ProgramDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.globus.swift.language.ProgramDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.globus.swift.language.ProgramDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.globus.swift.language.ProgramDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.globus.swift.language.ProgramDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.globus.swift.language.ProgramDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.globus.swift.language.ProgramDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.globus.swift.language.ProgramDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.globus.swift.language.ProgramDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.globus.swift.language.ProgramDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.globus.swift.language.ProgramDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.globus.swift.language.ProgramDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.globus.swift.language.ProgramDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.globus.swift.language.ProgramDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.globus.swift.language.ProgramDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.globus.swift.language.ProgramDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.globus.swift.language.ProgramDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.globus.swift.language.ProgramDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.globus.swift.language.ProgramDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.globus.swift.language.ProgramDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.globus.swift.language.ProgramDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.globus.swift.language.ProgramDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.globus.swift.language.ProgramDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.globus.swift.language.ProgramDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.globus.swift.language.ProgramDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.globus.swift.language.ProgramDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.globus.swift.language.ProgramDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.globus.swift.language.ProgramDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.globus.swift.language.ProgramDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.globus.swift.language.ProgramDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.globus.swift.language.ProgramDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link XMLInputStream} */
        public static org.globus.swift.language.ProgramDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.globus.swift.language.ProgramDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link XMLInputStream} */
        public static org.globus.swift.language.ProgramDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.globus.swift.language.ProgramDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
