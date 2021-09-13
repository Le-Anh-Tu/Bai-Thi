    package Codegym;

    public class Person {
        private String id;
        private String group;
        private String name;
        private String genDer;
        private String dateOfBirth;

        public Person() {
        }

        public Person(String id, String group, String name, String genDer, String dateOfBirth) {
            this.id = id;
            this.group = group;
            this.name = name;
            this.genDer = genDer;
            this.dateOfBirth = dateOfBirth;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGenDer() {
            return genDer;
        }

        public void setGenDer(String genDer) {
            this.genDer = genDer;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", group='" + group + '\'' +
                    ", name='" + name + '\'' +
                    ", genDer='" + genDer + '\'' +
                    ", dateOfBirth='" + dateOfBirth + '\'' +
                    '}';
        }
    }

