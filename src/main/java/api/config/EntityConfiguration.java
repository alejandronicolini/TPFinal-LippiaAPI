package api.config;

import services.*;

public enum EntityConfiguration {

    TIME {
        @Override
        public Class<?> getEntityService() {
            return TimeEntryService.class;
        }
    },
    EMPTY {
        @Override
        public Class<?> getEntityService() {
            return EmptyService.class;
        }
    },
    ERROR {
        @Override
        public Class<?> getEntityService() {
            return ErrorService.class;
        }
    };



    public abstract Class<?> getEntityService();
}
