package io.github.roaker666.statemachine.builder;


public interface ExternalParallelTransitionBuilder<S, E, C> {
    /**
     * Build transition source state.
     * @param stateId id of state
     * @return from clause builder
     */
    ParallelFrom<S, E, C> from(S stateId);

}
